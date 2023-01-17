import { Box } from "@mui/material";
import React from "react";
import { getFavoriteStorage } from "../Components/utils/localStore";
import CardComponet from "../Components/CardComponet";

//Este componente debera ser estilado como "dark" o "light" dependiendo del theme del Context

const Favs = () => {
  const data = getFavoriteStorage();

  return (
    <>
      <h1 style={{marginTop: 'auto'}}>Favorite Dentists</h1>
      <Box sx={{
          display: 'flex',
          justifyContent: 'space-evenly',
          gap: '1rem',
          minWidth: '90vw',
          height: 'auto',
          flexWrap: 'wrap',
          margin: '0 auto'
        }}>
        {data.map(item => (
          <CardComponet key={item.id} item={item}/>
        ))}
      </Box>
    </>
  );
};

export default Favs;
