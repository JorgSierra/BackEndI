import { Favorite, FavoriteBorder } from "@mui/icons-material";
import { Box, Button, Card, CardActions, CardContent, CardMedia, Checkbox, Typography } from "@mui/material";
import React, { useState }  from "react";
import { Link } from "react-router-dom";
import doctor from '../images/doctor.jpg'
import { isFavorite, setFavoriteDentist, remFavoriteDentist } from "./utils/localStore"; 

const CardComponet = ({ item }) => {
  const [fav, setFav] = useState(isFavorite(item.id));
  const label = { inputprops: { 'aria-label': 'Checkbox demo' } };

  const toggleFav = ()=>{
    if (isFavorite(item.id)){
      remFavoriteDentist(item.id);
      setFav(false);
    }
    else{
      const toAdd = {
        id: item.id,
        username: item.username,
        name: item.name
      }
      setFavoriteDentist(toAdd);
      setFav(true);
    }
  }

  return (
    <Card sx={{ minWidth: 300 }} >
      <CardMedia
        component="img"
        alt={`Doctor: ${item.name}`}
        height="140"
        image={doctor}
      />
      <CardContent sx={{ maxWidth: '90%' }}>
        <Typography gutterBottom variant="h5" component="div">
          {item.name}
        </Typography>
        <Typography variant="" color="text.secondary" component='p'>
          {`User name: ${item.username}`}
        </Typography>
      </CardContent>
      <CardActions>
        <Box>
          <Checkbox {...label} icon={<FavoriteBorder />} checkedIcon={<Favorite />} checked={fav} onClick={toggleFav}/>
        </Box>
        <Button sx={{
          padding: '0', 
          backgroundColor: '#1976D2', 
          '&:hover': {
            backgroundColor: '#3b8fe2',
          },
        }} >
          <Link style={{ 
            color:'white', 
            textDecoration: 'none', 
            textTransform: 'uppercase', 
            padding: '.5rem',
            paddingTop: '.2rem',
            paddingBottom: '.2rem', 
            margin: '0',
            borderRadius: '5px'
          }} 
        to={`/detail/${item.id}` }>Detail</Link></Button>
      </CardActions>
    </Card>
  );
};

export default CardComponet;
