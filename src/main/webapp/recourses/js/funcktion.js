function deleteStudents() {
    var idsToDelete = "";
    var checkBoxes = document.getElementsByClassName('idStudent');

    for (var i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            idsToDelete = idsToDelete + checkBoxes[i].value + " ";
        }
    }
    if (idsToDelete === "") {
        alert("Please select for delete");
        return;
    }
    var hidden = document.getElementById('hiddenDelete');
    hidden.value = idsToDelete;
    document.getElementById('formDelete').submit();

}