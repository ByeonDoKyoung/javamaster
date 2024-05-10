/**
 * portal.js
 */
const showTitles = ['id', 'centerName', 'address', 'sido', 'phoneNumber'];

let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=wrdmen0m%2BeS1oVqWyH9%2F52qRP57qkInDghOgAfwnt87vlJhJr192xl6rp0EOoFwlGBCb82RlHlICgBqEE4Rc3Q%3D%3D'

let totalData = []

// 메ㅑghcnf
fetch(url)
	.then(result => result.json())
	.then(data => {
		console.log(data);
		totalData = data.data;
		/*data.data.forEach(center =>{
		let tr = makeRow(center);
		document.querySelector('#list').appendChild(tr);
		})*/
		showPaging(2);
		pagingList();
	})
	.catch(console.log);

// 링크 클릭하면 페이지 호출
document.querySelectorAll('.pagination a').forEach(aTag => {
	console.log(aTag);
	aTag.addEventListener('click', function(e) {
		e.prventDefault(); // a 페이지이동 차단
		let page = this.innerText;
		showPaging(page);
	})
})

// pagingList: 전체건수를 계산해서 284건 29페이지
let totalCnt = 284;
function pagingList(page = 1) {
	let pagination = document.querySelector('.pagination')
	pagination.innerHTML = '';

	let endPage, startPage;
	let prev, next;
	let realEnd = Math.ceil(totalCnt / 10);
	endPage = Math.ceil(page / 10) * 10;
	startPage = endPage - 9;
	next = endPage < realEnd ? true : false;
	prev = startPage > 1; 
	
	//console.log(startPage, endPage);

	// aTag 생성 이벤트추가
	
	for (let n = startPage; n <= endPage; n++) {
		let aTag = document.createElement('a');
		aTag.setAttribute('href', '#');
		aTag.innerHTML = n;
		if (page == n) {
			aTag.className = 'active'; // class 속성지정
		}
		aTag.addEventListener('click', function(e) {
			let page = e.target.innerHTML;
			showPaging(page);
		})
		pagination.appendChild(aTag);
	}
}

// 페이지 -> 10개씩 출력
function showPaging(page = 1) { // 0 ~ 9: 1page,  10~19: 2page
	let startNo = (page - 1) * 10;
	let endNo = page * 10;
	let fAry = totalData.filter((center, idx) => {
		if (idx >= startNo && idx < endNo) {
			return true;
		}
	})
	// 목록 삭제
	document.querySelector('#List').innerHTML = '';

	fAry.forEach(center => {
		let tr = makeRow(center);
		document.querySelector('#List').appendChild(tr);
	})
	//console.log(fAry);
	pagingList(page); // 페이지목록생성
}

// 데이터(센터) tr함수
function makeRow(center = {}) {
	// 한건에 대한 처리
	let tr = document.createElement('tr');
	showTitles.forEach(title => {
		let td = document.createElement('td');
		let name = center[title];
		td.innerHTML = (name + '').replace('코로나19', '');
		tr.appendChild(td);
	});
	return tr;
}// end of makeRow.