function deleteBy(id){
    // Obtener y formatear id
    const url = '/odontologos/'+ id;
    const settings = {
        method: 'DELETE'
    }
    fetch(url,settings)
    .then(response => {
        switch (response.status) {
            case 404:
                alert("Error al eliminar");
                break;
            case 500:
                alert("Primero elimine los turnos asociados");
                break;
            case 200:
                // Borrar la fila eliminada
                let row_id = "#tr_" + id;
                document.querySelector(row_id).remove();
                break;
        }
    })
}