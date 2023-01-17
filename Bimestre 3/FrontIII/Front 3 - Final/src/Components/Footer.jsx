import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Container from '@mui/material/Container';
import { Box, Typography } from '@mui/material';
import dh from '../images/DH.png'
import icofacebook from '../images/ico-facebook.png'
import icoinstagram from '../images/ico-instagram.png'
import icotiktok from '../images/ico-tiktok.png'
import icotiwhatsapp from '../images/ico-whatsapp.png'


const itemData = [

    {
        img: icofacebook,
        link: 'https://www.facebook.com'
    },

    {
        img: icotiktok,
        link: 'https://www.tiktok.com/'
    },

    {
        img: icoinstagram,
        link: 'https://www.instagram.com'
    },

    {
        img: icotiwhatsapp,
        link: 'https://www.whatsapp.com'
    }

]


function ResponsiveAppBar() {


    return (

            <AppBar position="static" sx={{ marginTop: 'auto' }}>
                <Container maxWidth="xl">
                    <Toolbar disableGutters sx={{ display: 'flex', justifyContent: 'space-between' }}>
                        <Box sx={{ display: 'flex' }}>
                            <Typography variant='h5'>Powered by</Typography>
                            <img style={{ width: '200px' }} src={dh} alt='dh' />
                        </Box>
                        <Box sx={{ display: 'flex', }}>
                            {itemData.map((item, index) => (
                                <a key={index} href={item.link} >
                                    <img
                                        style={{ width: '50px', height: 'auto', marginLeft: '1rem' }}
                                        src={`${item.img}`}
                                        alt={index}
                                        loading="lazy"
                                    />
                                </a>
                            ))}
                        </Box>
                    </Toolbar>
                </Container>
            </AppBar>

    );
}
export default ResponsiveAppBar;