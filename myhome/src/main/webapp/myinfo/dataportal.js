/**
 * portal.js
 */
const showTitles = ['id','centerName','address','sido','phoneNumber'];
 let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=wrdmen0m%2BeS1oVqWyH9%2F52qRP57qkInDghOgAfwnt87vlJhJr192xl6rp0EOoFwlGBCb82RlHlICgBqEE4Rc3Q%3D%3D'
 fetch(url)
 .then(result => result.json())
 .then(data => {
	console.log(data);
	data.data.forEach(center =>{
		let tr = makeRow(center);
		document.querySelector('#list').appendChild(tr);
	})
 })
 .catch(console.log);
 
 // 데이터(센터) tr함수
 function makeRow(center = {}){
	// 한건에 대한 처리
	let tr = document.createElement('tr');
showTitles.forEach(title => {
		let td = document.createElement('td');
		let name = center[title];
		td.innerHTML =name.replace('코로나19','');
		tr.appendChild(td);
	});
	return tr;
}// end of makeRow.