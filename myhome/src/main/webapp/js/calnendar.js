/**
 * calendar.js
 */
document.addEventListener("DOMContentLoaded", initForm);

	

function initForm(){
	let show = document.querySelector('#show');
	show.appendChild(svc.makeTable());
	document.querySelector("#show>table").appendChild(svc.makeHeader2());
	document.querySelector("#show>table").appendChild(svc.makeBody(5));
}

const svc = {
	//<table><caption></caption></table>
	makeTable: function(){
		let tbl = document.createElement('table');
		tbl.setAttribute('border', '2');
		let cap = document.createElement('caption');
		cap.innerText('월달');
		tbl.appendChild(cap);
		console.log(tbl);
		return tbl;
	},
	makeHeader: function(){
		const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
		let thd = document.createElement('thead');
		let tr = document.createElement('tr');
		days.forEach((day) =>  {
			let th = document.createElement('th');
			th.innerText = day;
			tr.appendChild(th)
		});
		thd.appendChild(tr);
		return thd;
	},
	makeHeader2: function(){
		 const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
		 let tr = days.reduce((acc, curVal) => {
			let th = document.createElement('th');
			th.innerHTML = curVal;
			acc.appendChild(th);
			return acc;
		}, document.createElement('tr')); // <th><th/>*7</tr>
		let thd = document.createElement('thead');
		
		return thd;
	},
	makeBody: function(month = 5){
		let tbd = document.createElement('tbody');
		let tr = document.createElement('tr');
		let spaces = this.getFirstDate(month); // getFirstDate(month) => 1일의 위치.
		for(let i = 0; i<spaces; i++){
			let td = document.createElement('td');
			td.innerHTML = "";
			tr.appendChild(td);
		}	
		// 날짜출력
		for(let d = 1; d<=this.getLastDate(month); d++){ // getLastDate(month) => 월의 마지막날을 반환	
			let td = document.createElement('td');
			td.innerHTML = d;
			tr.appendChild(td);
			if((d + spaces) % 7 == 0){
				// 토요일이 끝나면 새로운 한주의시작
				tbd.appendChild(tr);
				tr = document.createElement('tr');
			}
		}
			tbd.appendChild(tr);
			return tbd;
	},
	getFirstDate(month){
		// Date객체 활용해서 계산
		let today = new Date(2024, month, -1, 1);
		console.log('요일의 위치: ', today.getDay());
		return today.getDay();
		switch(month){
			case 5:
				return 3;
			case 6:
				return 6;
		}
	},
	getLastDate(month){
		let today = new Date(2024, month, 1);
		console.log
		switch(month){
			case 5:
				return 31;
			case 6:
				return 30;
		}
	}
}// end