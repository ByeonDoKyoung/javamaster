/** 
 * object.js(객체, 함수)
 * 객체(속성,메소드)
 */

const obj ={ 
	name: "홍길동",
	age: 20,
	showInfo: function(){
		return `이름은 ${this.name} 이고 나이는 ${this.age}입니다.`
	},
	empList: function(){
		// Ajax 
		fetch('../empList.json')
		.then(function(result){
			return result.json(); // json문자열 -> 객체변환
		})
		.then(function(result){
			console.log(result); //DOM활용
			result.forEach(function(member){
				let tr = document.createElement('tr');
				for(let prop in member){
					let td = document.createElement('td');
					td.ineerText = member[prop];
					tr.appendChild(td);
				}
				document.querySelector('tbody').appendChild(tr);
			});
		})
	}
} // new object

obj.name = "Hongkildong";
console.log(`이름:${obj.name}, 나이:${obj["age"]}`);
console.log(obj.showInfo());
console.log(window);
// 속성확인
for(let prop in obj){
	console.log(`속성:${prop}, 값:${obj[prop]}`);
}
console.clear();
obj.empList();
