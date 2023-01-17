import { Box } from '@mui/material';
import React, { useContext, } from 'react'
import { ContextGlobal } from '../Components/utils/global.context';
import CardComponet from '../Components/CardComponet';

const Home = () => {
  const { data} = useContext(ContextGlobal);

  return (
    <>
      <h1 style={{marginTop: 'auto', paddingTop: '5rem'}}>Home</h1>
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
  )
}

export default Home