
function beginEditingPost(id) {
    let paragraph = document.getElementById("postContent" + id);
    let textarea = document.getElementById("postTextArea" + id);
    let saveButton = document.getElementById("postSaveButton" + id);

    paragraph.style.visibility = 'hidden';
    textarea.style.visibility = 'visible';
    textarea.value += paragraph.textContent;
    saveButton.style.visibility = 'visible';
}