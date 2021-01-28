/*
Script Externe
*/
var counter = 0;

counter++;

function afficher(msg) {
	alert(msg + " : Counter = " + counter);
	counter++;
}

var f1 = afficher;

afficher("Script Externe");