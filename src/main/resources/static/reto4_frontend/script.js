//START FARM------------------------------------------------------------------------------------------------------------

function getFarm(){
$.ajax({
url:"http://129.151.110.174:81/api/Farm/all",
type:"GET",
datatype:"JSON",
success:function(response){
showFarm(response);
}
});
}

function showFarm(response){
let myTable="<table>";
	for(i=0;i<response.length;i++){
	myTable+="<tr>";
		myTable+="<td>"+response[i].id+"</td>";
		myTable+="<td>"+response[i].name+"</td>";
		myTable+="<td>"+response[i].address+"</td>";
		myTable+="<td>"+response[i].extension+"</td>";
		myTable+="<td>"+response[i].description+"</td>";
		myTable+="<td><div class='d-flex justify-content-center'><div onclick='deleteFarm("+response[i].id+")' class='btn btn-danger col-xl-auto'>delete</div><div onclick='updateFarm("+response[i].id+")' class='btn btn-success col-xl-auto'>update</div></div></td>";
	myTable+="</tr>";
	}
myTable+="</table>";
$("#resultFarm").html(myTable);
}

function saveFarm(){
let var1 = {
name:$("#fname").val(),
address:$("#faddress").val(),
extension:$("#fextension").val(),
description:$("#fdescription").val()
};

$.ajax({
type:'POST',
contentType: "application/json; charset=utf-8",
dataType: 'JSON',
data: JSON.stringify(var1),

url:"http://129.151.110.174:81/api/Farm/save",


success:function(response) {
console.log(response);
window.location.reload()

},

error: function(jqXHR, textStatus, errorThrown) {
window.location.reload()

}
});
}


function deleteFarm(idItem){
    let myData={
        id:idItem
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.110.174:81/api/Farm/"+idItem,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(response){
            $("#resultFarm").empty();
            getFarm();
        }
    });
}


function updateFarm(idItem) {

var datos={
		id:idItem,
        name:$("#fname").val(),
        address:$("#faddress").val(),
        extension:$("#fextension").val(),
        description:$("#fdescription").val(),
        category:$("#fcategory").val()
	}

var dataToSend=JSON.stringify(datos);

$.ajax({
	datatype:'json',
	data:dataToSend,
	contentType:'application/json',
    url:"http://129.151.110.174:81/api/Farm/update",
	type:'PUT',

	success:function(response) {

		$("#resultFarm").empty();
	    $("#fname").val("");
	    $("#faddress").val("");
	    $("#fextension").val("");
	    $("#fdescription").val("");
	    getFarm();

	},

	error:function(jqXHR, textStatus, errorThrown) {

	}
});
}



//FINAL FARM----------------------------------------------------------------------------------------------------
//START CATEGORY------------------------------------------------------------------------------------------------------------
function getCategory(){
$.ajax({
url:"http://129.151.110.174:81/api/Category/all",
type:"GET",
datatype:"JSON",
success:function(response){
showCategory(response);
}
});
}
function showCategory(response){
let myTable="<table>";
	for(i=0;i<response.length;i++){
	myTable+="<tr>";
		myTable+="<td>"+response[i].id+"</td>";
		myTable+="<td>"+response[i].name+"</td>";
		myTable+="<td>"+response[i].description+"</td>";
		myTable+="<td><div class='d-flex justify-content-center'><div onclick='deleteCategory("+response[i].id+")' class='btn btn-danger col-xl-auto'>delete</div><div onclick='updateCategory("+response[i].id+")' class='btn btn-success col-xl-auto'>update</div></div></td>";
	myTable+="</tr>";
	}
myTable+="</table>";
$("#resultCategory").html(myTable);
}

function saveCategory(){
let var1 = {
name:$("#cname").val(),
description:$("#cdescription").val()
};

$.ajax({
type:'POST',
contentType: "application/json; charset=utf-8",
dataType: 'JSON',
data: JSON.stringify(var1),

url:"http://129.151.110.174:81/api/Category/save",


success:function(response) {
console.log(response);
window.location.reload()

},

error: function(jqXHR, textStatus, errorThrown) {
window.location.reload()

}
});
}

function deleteCategory(idItem){
    let myData={
        id:idItem
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.110.174:81/api/Category/"+idItem,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(response){
            $("#resultCategory").empty();
            getCategory();
        }
    });
}


function updateCategory(idItem) {

var datos={
	id:idItem,
	name:$("#cname").val(),
	description:$("#cdescription").val()
	}

var dataToSend=JSON.stringify(datos);

$.ajax({
	datatype:'json',
	data:dataToSend,
	contentType:'application/json',
    url:"http://129.151.110.174:81/api/Category/update",
	type:'PUT',

	success:function(response) {
	

		$("#resultCategory").empty();
	    $("#cname").val("");
	    $("#cdescription").val("");
	    getCategory();

	},

	error:function(jqXHR, textStatus, errorThrown) {

	}
});
}

//FINAL CATEGORY--------------------------------------------------------------------------------------------------------
//$("#items").append(response.items[2].id,response.items[2].address,response.items[2].exension,response.items[2].category_id,response.items[2].name,)
//START CLIENT------------------------------------------------------------------------------------------------------
function getClient(){
$.ajax({
url:"http://129.151.110.174:81/api/Client/all",
type:"GET",
datatype:"JSON",
success:function(response){
showClient(response);
}
});
}
function showClient(response){
let myTable="<table>";
	for(i=0;i<response.length;i++){
	myTable+="<tr>";
		myTable+="<td>"+response[i].idClient+"</td>";
		myTable+="<td>"+response[i].email+"</td>";
		myTable+="<td>"+response[i].password+"</td>";
		myTable+="<td>"+response[i].name+"</td>";
		myTable+="<td>"+response[i].age+"</td>";
		myTable+="<td><div class='d-flex justify-content-center'><div onclick='deleteClient("+response[i].idClient+")' class='btn btn-danger col-xl-auto'>delete</div><div onclick='updateClient("+response[i].idClient+")' class='btn btn-success col-xl-auto'>update</div></div></td>";
	myTable+="</tr>";
	}
myTable+="</table>";
$("#resultClient").html(myTable);
}
function saveClient(){
let var1 = {
email:$("#clemail").val(),
password:$("#clpassword").val(),
name:$("#clname").val(),
age:$("#clage").val()
};

$.ajax({
type:'POST',
contentType: "application/json; charset=utf-8",
dataType: 'JSON',
data: JSON.stringify(var1),

url:"http://129.151.110.174:81/api/Client/save",


success:function(response) {
console.log(response);
window.location.reload()

},

error: function(jqXHR, textStatus, errorThrown) {
window.location.reload()

}
});
}

function deleteClient(idItem){
    let myData={
        idClient:idItem
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://129.151.110.174:81/api/Client/"+idItem,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(response){
            $("#resultClient").empty();
            getClient();
        }
    }); 
}


function updateClient(idItem) {

var datos={
		idClient:idItem,
        email:$("#clemail").val(),
        password:$("#clpassword").val(),
        name:$("#clname").val(),
        age:$("#clage").val()
	}

var dataToSend=JSON.stringify(datos);

$.ajax({
	datatype:'json',
	data:dataToSend,
	contentType:'application/json',
    url:"http://129.151.110.174:81/api/Client/update",
	type:'PUT',

	success:function(response) {

		$("#resultClient").empty();
	    $("#clemail").val("");
	    $("#clpassword").val("");
	    $("#clname").val("");
	    $("#clage").val("");
	    getClient();

	},

	error:function(jqXHR, textStatus, errorThrown) {

	}
});
}

//FINAL CLIENT-------------------------------------------------------------------------------------------------------
