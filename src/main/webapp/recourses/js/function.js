function deleteStudents() {
    let idsToDelete = "";
    let checkBoxes = document.getElementsByClassName('idStudent');

    for (let i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            idsToDelete += checkBoxes[i].value + " ";
        }
    }
    if (idsToDelete === "") {
        alert("Please select for delete");
        return;
    }
    let hidden = document.getElementById('hiddenDel');
    hidden.value = idsToDelete;
    document.getElementById('formDelete').submit();
}

function modifyStudents() {
    var idToModify = "";

    /*вытягиваем все чекбоксы с student.jsp -> (<td><input type="checkbox" value="${st.id}" class="idStudent">)
    * из класса 'idStudent'*/
    var checkBoxes = document.getElementsByClassName('idStudent');

    var countcheckedBox = 0;
    for (let i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            countcheckedBox++;
            idToModify = checkBoxes[i].value;
        }
    }
    if (countcheckedBox === 0) {
        alert("Необходимо выбрать одного студента");
        return;
    }
    if (countcheckedBox > 1) {
        alert("Необходимо выбрать только одного студента");
        return;
    }
    /*находим  id="hiddenModify"*/
    var hidden = document.getElementById('hiddenModify');
    /*и в поле value="" кладем собранные id чекбокс-ов*/
    hidden.value = idToModify;
    /*находим id="formModify" и "нажимаем" кнопку отправить (submit)*/
    document.getElementById('formModify').submit();
}

function progressStudent() {
    var idProgress = "";

    var checkBoxes = document.getElementsByClassName('idStudent');

    var countcheckedBox = 0;
    for (let i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            countcheckedBox++;
            idProgress = checkBoxes[i].value;
        }
    }
    if (countcheckedBox === 0) {
        alert("Необходимо выбрать одного студента");
        return;
    }
    if (countcheckedBox > 1) {
        alert("Необходимо выбрать только одного студента");
        return;
    }
    var hidden = document.getElementById('hiddenProgress');
    hidden.value = idProgress;
    document.getElementById('formProgress').submit(); //id="formProgress"
}