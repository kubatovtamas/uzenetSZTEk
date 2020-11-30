
function beginEditingTopic(id) {
    let paragraph = document.getElementById("topicDescription" + id);
    let textarea = document.getElementById("topicTextArea" + id);
    let saveButton = document.getElementById("topicSaveButton" + id);

    paragraph.style.visibility = 'hidden';
    textarea.style.visibility = 'visible';
    textarea.value += paragraph.description;
    saveButton.style.visibility = 'visible';
}
