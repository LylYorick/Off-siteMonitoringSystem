/**
 * Paginater 分页.
 * @author fred.du
 */
Paginater = {
	createPageField: function(id) {
		var pageField = document.createElement("input");
		pageField.id = id;
		pageField.type = "hidden";
		pageField.name = "page";
		
		return pageField;
	},

	refresh: function() {
		document.getElementById("_refresh").click();
	},
	
	toPage: function(pageIndex) {
		var pageFormIndex = document.getElementById('pageFormIndex').value;

		if (pageFormIndex == 'null' || pageFormIndex.length == 0) {
			pageFormIndex = '0';
		}

		var searchForm = document.forms[pageFormIndex];
		
		if (typeof searchForm.page == "undefined") {
			var pageField = this.createPageField("_page");
			searchForm.appendChild(pageField);
		}

		document.getElementById("_page").value = pageIndex;
		searchForm.submit();
	},
	
	goPage: function() {
		var pageIndex = document.getElementById("goPageIndex").value;
		if (pageIndex.length == 0 || !/^([0-9]*)$/.test(pageIndex)) {
			return;
		}
		
		this.toPage(pageIndex);
	}
}
