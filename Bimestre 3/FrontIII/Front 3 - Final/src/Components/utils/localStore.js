export const getFavoriteStorage = () => {
    const data = localStorage.getItem("fav");
    if (data){
        return JSON.parse(data);
    }
    else{
        return [];
    }
};

export const isFavorite = (id) => {
    const data = getFavoriteStorage();
    const result = data.filter(dentist => dentist.id === id);
    return result.length === 1;
};

export const setFavoriteDentist = (dentist) => {
    let data = getFavoriteStorage();
    data.push(dentist);
    localStorage.setItem("fav", JSON.stringify(data));
}

export const remFavoriteDentist = (id) => {
    let data = getFavoriteStorage();
    const index = data.findIndex(dentist => dentist.id === id);
    data.splice(index, 1);
    localStorage.setItem("fav", JSON.stringify(data));
}