// Load pets automatically when page opens
window.onload = loadPets;

// ADD Pet
function addPet(){
    var form = new FormData();
    form.append("name", document.getElementById("name").value);
    form.append("age", document.getElementById("age").value);
    form.append("type", document.getElementById("type").value);

    fetch("addPet", { method:"POST", body:form })
    .then(res=>res.text())
    .then(()=>{ loadPets(); alert("Added Successfully"); });
}


// LOAD PETS in table
function loadPets(){
    fetch("viewPets")
    .then(res=>res.json())
    .then(data => {
        let table = `<table><tr><th>ID</th><th>Name</th><th>Type</th><th>Age</th><th>Action</th></tr>`;
        data.forEach(p=>{
            table += `<tr>
                        <td>${p.id}</td>
                        <td><input value="${p.name}" id="n${p.id}"></td>
                        <td><input value="${p.type}" id="t${p.id}"></td>
                        <td><input value="${p.age}" id="a${p.id}"></td>
                        <td>
                            <button onclick="updatePet(${p.id})">Update</button>
                            <button onclick="deletePet(${p.id})" style="background:red;">Delete</button>
                        </td>
                      </tr>`;
        });
        table += "</table>";
        document.getElementById("petTable").innerHTML = table;
    });
}


// UPDATE
function updatePet(id){
    let form = new FormData();
    form.append("id", id);
    form.append("name", document.getElementById("n"+id).value);
    form.append("type", document.getElementById("t"+id).value);
    form.append("age",  document.getElementById("a"+id).value);

    fetch("editPet", { method:"POST", body:form })
    .then(()=>{ alert("Updated!"); loadPets(); });
}


// DELETE
function deletePet(id){
    fetch("deletePet?id="+id)
    .then(()=>{ alert("Deleted"); loadPets(); })
}
