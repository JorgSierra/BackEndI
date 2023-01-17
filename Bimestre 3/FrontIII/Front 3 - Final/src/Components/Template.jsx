import { Box } from '@mui/material'
import React from 'react'
import { Outlet } from 'react-router-dom'
import Footer2 from './Footer'
import Navbar from './Navbar'



const Template = () => {
  return (
    <Box sx={{
      display: 'flex',
      alignItems: 'center',
      flexDirection: 'column',
      minHeight: '100vh'
      }}>
        <Navbar />
        <Outlet/>
        <Footer2 />
    </Box>
  )
}

export default Template