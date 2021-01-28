function Menu(currentId) {
	this.current = document.getElementById(currentId);
}

Menu.prototype.show = function(id) {
	this.current.style.display = "none";
	this.current = document.getElementById(id);
	this.current.style["display"] = "block";
}

var menu;

/****************************************************************************/
function ajouterProduit(p) {
	if (p == undefined) {
		p = new Produit(value("ref"), value("desig"), value("pu"), value("qs"));
	}
	if (stock.add(p)) {
		addStockRow(p);
	}
}

function chercherProduit(index) {
	var ref = value("ventes-ref-" + index);
	var p = stock.getByRef(ref);
	if (p != undefined) {
		setContent("ventes-desig-" + index, p.desig);
		setContent("ventes-pu-" + index, p.pu);
	}
}
