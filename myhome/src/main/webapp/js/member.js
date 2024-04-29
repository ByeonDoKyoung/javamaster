/**
 * member.js
 */
// 추가 클릭이벤트등록.
// 사용자의 입력값 3개 => tr > td * 3 => tbody 하위요소 추가

 document.querySelector('#addMember') //
 	.addEventListener('click',addMemberFnc);
 	
 function addMemberFnc(){
	 let memNum = document.querySelector('#memberNum').value;
	 let memName = document.querySelector('#memberName').value;
	 let memPoint = document.querySelector('#memberPoint').value;
	const mem = { memNum, memName, memPoint}
	let tr = makeRow(mem);
	
 	document.querySelector('table#tlist tbody').appendChild(tr);
}
 
 // member 정보를 활용 tr반환.
function makeRow(member ={memNum, memNAme, memPoint}) {
	
	// tr생성
	let tr = document.createElement('tr');
	// tr에 click 이벤트 등록.
	tr.addEventListener('click',function(e){
		e.stopPropagation();
		// tr의 자식요소 children.
		document.querySelector('#memberNum').value = 
			tr.children[0].innerHTML;
		document.querySelector('#memberName').value = 
			tr.children[1].innerHTML;
		document.querySelector('#memberPoint').value = 
			tr.children[2].innerHTML;
	}, true)
	for (let prop in member){
		let td = document.createElement('td');
		td.innerText = member[prop]; // mem.memNO
		tr.appendChild(td);
 	}	
 	//  <td><button>삭제</button></td>
 	let btn = document.createElement('button');
 	let td = document.createElement('td');
 	btn.innerText = '삭제';
 	btn.addEventListener('click', deleteRow, true);
 	td.appendChild(btn);
 	tr.appendChild(td);
 	
 	// 체크박스
 	td = document.createElement('td');
 	let chk = document.createElement('input');
 	chk.setAttribute('type', 'checkbox');
 	chk.addEventListener('change', changeRow);
	td.appendChild(chk);
 	tr.appendChild(td);
 	
 	return tr;
}  // end of makeRow.
function deleteRow(event){
	event.stopPropagation(); // 상하위 요소로 이벤트차단
	console.log(event.target.parentElement.parentElement.remove());
}
function changeRow(e){
	// this => <input type = "checkbox" checked>
	console.log(this.chacked); // checkbox일 경우
}
 // members 배열의 갯수만큼 tr 생성.
 members.forEach(function(item) {
	let tr = makeRow(item);
	document.querySelector('table#tlist tbody').appendChild(tr);
 });	
 
 // thead input[type="checkbox"]
 document.querySelector('thead input[type = "checkbox"]')
 	.addEventListener('change', function(){
		// event핸들러 => this
		// thead => tbody 적용.
		let inp = this;
		document.querySelectorAll('tbody input[type= "checkbox"]')
			.forEach((item) => { // 화살표함수
				console.log(this);
				item.checked = this.checked;
			})
	});
	