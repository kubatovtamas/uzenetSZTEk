
function beginEditingTopic(id) {
    let paragraph = document.getElementById("topicDescription" + id);
    let textarea = document.getElementById("topicDescriptionTextArea" + id);
    let saveButton = document.getElementById("topicSaveButton" + id);

    paragraph.style.visibility = 'hidden';
    textarea.style.visibility = 'visible';
    textarea.value = paragraph.textContent;
    saveButton.style.visibility = 'visible';
}
