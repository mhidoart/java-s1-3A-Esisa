var counter = 0;

function addStockRow(p) {
	var table = document.getElementById('table-stock');
	var row = table.insertRow();
	row.insertCell().innerHTML = p.ref;
	row.insertCell().innerHTML = p.desig;
	row.insertCell().innerHTML = p.pu;
	row.insertCell().innerHTML = p.qs;
}

function setValue(id, value) {
	document.getElementById(id).value = value;
}

function value(id) {
	return document.getElementById(id).value;
}

function setContent(id, content) {
	document.getElementById(id).innerHTML = content;
}

function content(id) {
	return document.getElementById(id).innerHTML;
}

function addContent(id, content) {
	document.getElementById(id).innerHTML += content;
}

function addTextBox() {
	counter++;
	var textbox = '<div class="TextBox">'
	+ '<input type="text" id="ventes-ref-' + counter + '"'
	+ ' onkeyup="chercherProduit(' + counter + ')" '
	+ ' placeholder="Référence Produit" />'
	+ '<div id="ventes-desig-' + counter + '"></div>'
	+ '<div id="ventes-pu-' + counter + '"></div>'
	+ '<input type="text" id="ventes-q-' + counter + '"' 
	+ '	placeholder="Quantité" />'
	+ '</div>'
	
	addContent("ventes-produits", textbox);
}

