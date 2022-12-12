function changePersonInputs(i) {
    let elems = document.getElementsByClassName("edit");
    let form = document.getElementById("form");
    switch (i){
        case 1: {
            form.attributes.getNamedItem("action").value = "person/create";
            form.style.display = "inline";
            document.getElementById("id").style.display = "none";
            document.getElementById("name").style.display = "inline";
            document.getElementById("login").style.display = "inline";
            document.getElementById("password").style.display = "inline";
            document.getElementById("email").style.display = "inline";
            elems.item(0).classList.remove("unselected");
            elems.item(1).classList.add("unselected")
            elems.item(2).classList.add("unselected")
            break;
        }
        case 2:{
            form.attributes.getNamedItem("action").value = "person/update";
            form.style.display = "inline";
            document.getElementById("id").style.display = "inline";
            document.getElementById("name").style.display = "inline";
            document.getElementById("login").style.display = "inline";
            document.getElementById("password").style.display = "inline";
            document.getElementById("email").style.display = "inline";
            elems.item(0).classList.add("unselected");
            elems.item(1).classList.remove("unselected")
            elems.item(2).classList.add("unselected")
            break;
        }
        case 3:{
            form.attributes.getNamedItem("action").value = "person/delete";
            form.style.display = "inline";
            document.getElementById("id").style.display = "inline";
            document.getElementById("name").style.display = "none";
            document.getElementById("login").style.display = "none";
            document.getElementById("password").style.display = "none";
            document.getElementById("email").style.display = "none";
            elems.item(0).classList.add("unselected");
            elems.item(1).classList.add("unselected")
            elems.item(2).classList.remove("unselected")
            break;
        }
        default:{
            break;
        }
    }
}

function changeGoodInputs(i) {
    let elems = document.getElementsByClassName("edit");
    let form = document.getElementById("form");
    switch (i){
        case 1: {
            form.attributes.getNamedItem("action").value = "good/create";
            form.style.display = "inline";
            document.getElementById("id").style.display = "none";
            document.getElementById("name").style.display = "inline";
            document.getElementById("price").style.display = "inline";
            elems.item(0).classList.remove("unselected");
            elems.item(1).classList.add("unselected")
            elems.item(2).classList.add("unselected")
            break;
        }
        case 2:{
            form.attributes.getNamedItem("action").value = "good/update";
            form.style.display = "inline";
            document.getElementById("id").style.display = "inline";
            document.getElementById("name").style.display = "inline";
            document.getElementById("price").style.display = "inline";
            elems.item(0).classList.add("unselected");
            elems.item(1).classList.remove("unselected")
            elems.item(2).classList.add("unselected")
            break;
        }
        case 3:{
            form.attributes.getNamedItem("action").value = "good/delete";
            form.style.display = "inline";
            document.getElementById("id").style.display = "inline";
            document.getElementById("name").style.display = "none";
            document.getElementById("price").style.display = "none";
            elems.item(0).classList.add("unselected");
            elems.item(1).classList.add("unselected")
            elems.item(2).classList.remove("unselected")
            break;
        }
        default:{
            break;
        }
    }
}

function changePurchaseInputs(i) {
    let elems = document.getElementsByClassName("edit");
    let form = document.getElementById("form");
    switch (i){
        case 1: {
            form.attributes.getNamedItem("action").value = "purchase/create";
            form.style.display = "inline";
            document.getElementById("number").style.display = "none";
            document.getElementById("personId").style.display = "inline";
            document.getElementById("goodId").style.display = "inline";
            elems.item(0).classList.remove("unselected");
            elems.item(1).classList.add("unselected")
            elems.item(2).classList.add("unselected")
            break;
        }
        case 2:{
            form.attributes.getNamedItem("action").value = "purchase/update";
            form.style.display = "inline";
            document.getElementById("number").style.display = "inline";
            document.getElementById("personId").style.display = "inline";
            document.getElementById("goodId").style.display = "inline";
            elems.item(0).classList.add("unselected");
            elems.item(1).classList.remove("unselected")
            elems.item(2).classList.add("unselected")
            break;
        }
        case 3:{
            form.attributes.getNamedItem("action").value = "purchase/delete";
            form.style.display = "inline";
            document.getElementById("number").style.display = "inline";
            document.getElementById("personId").style.display = "none";
            document.getElementById("goodId").style.display = "none";
            elems.item(0).classList.add("unselected");
            elems.item(1).classList.add("unselected")
            elems.item(2).classList.remove("unselected")
            break;
        }
        default:{
            break;
        }
    }
}