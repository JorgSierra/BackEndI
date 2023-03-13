const tema = confirm('Desea aplicar el tema oscuro?');

if (tema) {
  document.querySelector('body').classList.add('dark')
}

let itemList = document.querySelectorAll('.item');

// itemList.forEach(element =>{
//   element.remove();
// });

let container = document.querySelector('.contenedor');
container.innerHTML = '';

let html = '';
itemList.forEach(element => {
  html += `<div class="item"> 
  ${element.innerHTML}
  </div>`
});

container.innerHTML = html;