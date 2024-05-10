/**
 * jsondata.js
 */

const employees = `[{"id":1,"first_name":"Arnuad","last_name":"Monkman","email":"amonkman0@usda.gov","gender":"Male","salary":4882},
{"id":2,"first_name":"Franklyn","last_name":"Yeoman","email":"fyeoman1@newsvine.com","gender":"Male","salary":4479},
{"id":3,"first_name":"Lonee","last_name":"Forcade","email":"lforcade2@spiegel.de","gender":"Female","salary":4058},
{"id":4,"first_name":"Dona","last_name":"Witsey","email":"dwitsey3@buzzfeed.com","gender":"Female","salary":3592},
{"id":5,"first_name":"Dani","last_name":"Olohan","email":"dolohan4@netscape.com","gender":"Female","salary":4073},
{"id":6,"first_name":"Denna","last_name":"Mournian","email":"dmournian5@last.fm","gender":"Female","salary":3136},
{"id":7,"first_name":"Shelton","last_name":"McGurn","email":"smcgurn6@illinois.edu","gender":"Male","salary":3908},
{"id":8,"first_name":"Sven","last_name":"Paudin","email":"spaudin7@facebook.com","gender":"Male","salary":3521},
{"id":9,"first_name":"Jobi","last_name":"Christophe","email":"jchristophe8@ow.ly","gender":"Female","salary":3876},
{"id":10,"first_name":"Lennard","last_name":"Ianni","email":"lianni9@wp.com","gender":"Male","salary":3065},
{"id":11,"first_name":"Amalea","last_name":"Issit","email":"aissita@networkadvertising.org","gender":"Polygender","salary":3802},
{"id":12,"first_name":"Bellina","last_name":"Blayd","email":"bblaydb@sciencedirect.com","gender":"Female","salary":4032},
{"id":13,"first_name":"Bartholomeo","last_name":"Clementet","email":"bclementetc@e-recht24.de","gender":"Male","salary":3450},
{"id":14,"first_name":"Lilah","last_name":"Autrie","email":"lautried@live.com","gender":"Female","salary":3303},
{"id":15,"first_name":"Nichol","last_name":"Stoop","email":"nstoope@merriam-webster.com","gender":"Female","salary":3245},
{"id":16,"first_name":"Celie","last_name":"Foley","email":"cfoleyf@google.pl","gender":"Female","salary":3425},
{"id":17,"first_name":"Chaddy","last_name":"Triplow","email":"ctriplowg@scribd.com","gender":"Male","salary":4240},
{"id":18,"first_name":"Angil","last_name":"Cellone","email":"acelloneh@miitbeian.gov.cn","gender":"Female","salary":4821},
{"id":19,"first_name":"Darb","last_name":"Labin","email":"dlabini@japanpost.jp","gender":"Female","salary":4671},
{"id":20,"first_name":"Carlin","last_name":"Ferneley","email":"cferneleyj@hubpages.com","gender":"Female","salary":4282}]`

//console.log(employees);
const empList = JSON.parse(employees); // 문자열 -> 객체
//console.log(empList);