
function beginEditingPost(id) {
    let paragraph = document.getElementById("postContent" + id);
    let textarea = document.getElementById("postTextArea" + id);
    let saveButton = document.getElementById("postSaveButton" + id);

    let originalTextContent = paragraph.textContent;

    console.log(paragraph)
    console.log(textarea)
    console.log(saveButton)

    paragraph.style.visibility = 'hidden';
    textarea.style.visibility = 'visible';
    textarea.value += originalTextContent;
    saveButton.style.visibility = 'visible';
}