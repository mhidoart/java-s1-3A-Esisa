function exp150() {
/*
	class Point {
		x = 10;
		y = 10;
		constructor(x, y) {
			//this.x = x;
			//this.y = y;
			Point.counter++;
		}
		
		toString() {
			return "Point(" + this.x + ", " + this.y + ")";
		}
		
		print() {
			print(this);
		}
		
		static counter = 11;
	}
	
	var p1 = new Point(20, 30);
	print(p1);
	print(typeof Point);
	separator();
	print(Point.prototype.toString);
	separator();
	p1.print();
	print(Point.counter);
*/
	function Point() {
		var _y = 20;
		Object.defineProperty(this, "y", 
				{
					get : function() {
						return _y;
					},
					set : function(param) {
						_y = param * 2;
					}
				}
		);
	}
	
	Object.defineProperty(Point.prototype, "x", 
			{
				configurable : true, 
				enumerable : true, 
				value : 20, 
				writable : false
			}
	);
	
	var p1 = new Point();
	print(p1.x);
	p1.x = 50;
	print(p1.x);
	separator();
	for(var p in p1) {
		print(" - " + p + " = " + p1[p]);
	}
	separator();
	p1.y = 30;
	print("y = " + p1.y)
}

function exp01() {
	print("Ceci est un test");
}

function exp02() {
	clear();
}

function exp03() {
	var x1 = 20;
	var x2 = new Number(20);
	var x3 = new Number(20);
	
	print(x1 + " de type : " + typeof x1);
	print(x2 + " de type : " + typeof x2);
	print("x1 == x2 : " + (x1 == x2));
	print("x1 == x3 : " + (x1 == x3));
	print("x2 == x3 : " + (x2 == x3));
	separator();
	print("x1 === x2 : " + (x1 === x2));
	print("x1 === 20 : " + (x1 === 20));
}

function exp04() {
	var s1 = "Une chaîne de caractères";
	var s2 = new String("Une chaîne de caractères");
	
	print(s1 + " de type : " + typeof s1);
	print(s2 + " de type : " + typeof s2);
	print("s1 == s2 : " + (s1 == s2));
	print("s1 === s2 : " + (s1 === s2));
}

function exp05() {
	function somme(x, y) {
		return x + y;
	}
	
	print("somme() est de type : " + typeof somme);
	print("somme.name : " + somme.name);
	print("somme.length : " + somme.length);
	
	var f = somme;
	print("f est de type : " + typeof f);
	print("f.name : " + f.name);
	print("f.length : " + f.length);
	
	var s = f(20, 30);
	print("s = " + s + " de type : " + typeof s);
	s = f("Java", "Script");
	print("s = " + s + " de type : " + typeof s);
}

function exp06() {
	var somme = function(x, y) { // fonction anonyme
		return x + y;
	};
	var mul = function(x, y) { // fonction anonyme
		return x * y;
	};
	
	print("somme est de type : " + typeof somme);
	print("mul est de type : " + typeof mul);
	
	function traitement(x, y, op) {
		return 2 * op(x, y);
	}
	
	var t1 = traitement(20, 30, somme);
	var t2 = traitement(20, 30, mul);
	var t3 = traitement(20, 30, function(x, y) {return x - y;});
	
	print("t1 = " + t1);
	print("t2 = " + t2);
	print("somme : " + somme);
	print("t3 = " + t3);
}

function exp07() {
	var x
	print("x = " + x)
	//print("y = " + y); => erreur
	print("x == undefined : " + (x == undefined))
	x = 30
	print("x == undefined : " + (x == undefined))
}

function exp08() {
	function somme(x, y) {
		if (x == undefined) x = 0;
		if (y == undefined) y = 0;
		return x + y;
	}
	
	var s1 = somme(20, 30);
	print("s1 = " + s1);
	
	var s2 = somme(20);
	print("s2 = " + s2);
	
	var s3 = somme(20, 30, 40, 50);
	print("s3 = " + s3);
}

function exp09() {
	function somme() {
		print("Nombre d'arguments d'appel : " + arguments.length);
		var s = 0;
		for (var i = 0; i < arguments.length; i++) {
			s = s + arguments[i];
		}
		return s;
	}
	
	var s1 = somme(20, 30);
	print("s1 = " + s1);
	
	var s2 = somme(20);
	print("s2 = " + s2);
	
	var s3 = somme(20, 30, 40, 50);
	print("s3 = " + s3);
	
	var s4 = somme("20", 30, 40, 50);
	print("s4 = " + s4);
}

function exp10() {
	var t1;
	t1 = [20, 56, 12];
	var t2 = new Array(20, 56, 12);
	
	print("t1 = {" + t1 + "} : de type : " + typeof t1);
	print("t2 = {" + t2 + "} : de type : " + typeof t2);
	t1[5] = 17;
	
	print("t1.length : " + t1.length + " => {" + t1 + "}");
	separator();
	for (var i = 0; i < t1.length; i++) {
		print(" - t1[" + i + "] = " + t1[i]);
	}
	separator();
	for (var index in t1) {
		print(" - t1[" + index + "] = " + t1[index]);
	}
}

function exp11() {
	var t1 = [];
	var t2 = new Array();
	
	
	t1.push('A');
	t1.push(20);
	t1.push('JavaScript');
	t1.push([1, 2, 3]);
	t1.push(new Number(30));
	t1.push(function(x, y) {return x + y});
	
	for (var i = 0; i < t1.length; i++) {
		print("t1[" + i + "] = " + t1[i] + " => " + typeof t1[i]);
	}
	
	print("function => " + t1[5](20, 30));
	
	var x = t1.pop();
	print("Elément supprimé : " + x);
	
	separator();
	for (var i in t) {
		print("t1[" + i + "] = " + t1[i] + " => " + typeof t1[i]);
	}
	
}
// POO
function exp12() {
	var p1 = new Object();
	p1.x = 20;
	p1.y = 30;
	
	p1.toString = function() {
		return "Point(" + this.x + ", " + this.y + ")";
	};
	
	
	var p2 = Object.create(p1); // p1 est le prototype de p2
								// Prototypage
	p2.x = 100;
	
	print("p1 : " + p1);
	print("p2 : " + p2); // Héritage prototypal
}

function exp13() {
	var prototype = { // JSON : JavaScript Object Notation
		// Propriétés :
		x : 20,
		y : 30,
		// Méthodes :
		toString : function() {
			return "(" + this.x + ", " + this.y + ")";
		}
	};
	
	var p2 = Object.create(prptotype);
	p2.x = 200;
	
	var p3 = p1;
	p3.x = 100;
	
	print("p1 = " + p1);
	print("p2 = " + p2);
	print("p3 = " + p3)
}

function exp14() {
	function Point(x, y, name) {
		if (name == undefined) name = "Point";
		// Propriétés :
		this.name = name;
		this.x = x;
		this.y = y;
		// Méthodes :
		// Version 1 : Mauvaise solution
		this.toString = function() {
			return this.name + "(" + this.x + ", " + this.y + ")";
		}
		
		this.print = function() {
			print("Point : " + this);
		}
	}
	
	var p1 = new Point(20, 30);
	var p2 = new Point(10, 15, "p2");
	p2.x = 345;
	
	p1.print();
	p2.print();
}

function exp15() {
	var p0 = {
		name : "p0",
		x : 20,
		y : 30,
		
		toString : function() {
			return this.name + "(" + this.x + ", " + this.y + ")"
		}
	};
	
	var p1 = Object.create(p0);
	p1.name = "p1";
	
	print(p0);
	print(p1);
	print("Le protyotype de p1 : " + Object.getPrototypeOf(p1));
	print("Le protyotype de p0 : " + Object.getPrototypeOf(p0));
	/*
	Object.prototype.toString = function() {????
		return "Object()";
	}
	*/
	Object.prototype.id = "110";

	var proto = Object.getPrototypeOf(Object.getPrototypeOf(p0));
	print("p0.id = " + p0.id)
	print("p1.id = " + p1.id)
	print("proto == Object.prototype : " + (proto == Object.prototype) );
	print("Le protyotype du prototype de p0 : " + proto);
}


function exp16() {
	function Point(x, y, name) {
		// Propriétés :
		if (name != undefined) {
			this.name = name;
		}
		this.x = x;
		this.y = y;
		
		Point.counter++;
	}
	// Méthodes :
	// Version 2 : Bonne solution
	Point.prototype.toString = function() {
		return this.name + "(" + this.x + ", " + this.y + ")";
	}
	
	Point.prototype.print = function() {
		print("Point : " + this);
	}
	
	Point.prototype.name = "Un Point"; // sera hérité par tous les points
	Point.counter = 0;
	
	
	var p1 = new Point(20, 30);
	var p2 = new Point(10, 15, "p2");
	p2.x = 345;
	
	p1.print();
	p2.print();
	
	print("Counter : " + Point.counter);
}


