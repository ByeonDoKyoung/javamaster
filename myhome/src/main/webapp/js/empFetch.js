/**
 * empFetch.js Ajax 기능을 fetch함수 활용
 */
document.addEventListener("DOMContentLoaded", initForm); //최초로 실행

// 화면로딩 후 처음 실행할 함수
function initForm() {
	// Ajax 호출.
	fetch('../empJson.json') // 반환결과 값이 promise 객체
		.then(result => result.json()) // 출력스트림(json) -> 객체변환
		.then((data) => {
			data.forEach(emp => {
				let tr = makeRow(emp);
				document.querySelector('#elist').appendChild(tr);
			})
		})
		.catch((err) => console.log(err));
}// end of initForm

function makeRow(emp = {}) {
	let props = ['empNO', 'empName', 'email', 'salary'];
	// 한건에 대한 처리
	let tr = document.createElement('tr');
	tr.setAttribute('data-no', emp.empNO);
	//tr.addEventListener('dblclick', modifyRow);
	props.forEach(prop => {
		let td = document.createElement('td');
		td.innerHTML = emp[prop];
		tr.appendChild(td);
	})
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.addEventListener('click', deleteRow);
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
}// end of makeRow

function deleteRow() {
	let eno = this.parentElement.parentElement.dataset.no;
	let tr = this.parentElement.parentElement;
	
	fetch(`../empsave.json?job=delete&empNo=${eno}`)
		.then(result => result.json())
		.then(data => {
			if (data.retCode == 'OK') {
				tr.remove();
			} else if (data.retCode == 'NG') {
				alert('처리중 에러발생.');
			} else {
				alert('처리코드 확인하세요.');
			}
		})
		.catch(err => console.log(err))
}// end of deleteRow
