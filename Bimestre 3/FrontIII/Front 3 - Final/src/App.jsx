import React, { useContext } from 'react'
import { Route, Routes } from "react-router-dom";
import Home from "./Routes/Home";
import Contact from './Routes/Contact'
import Favs from './Routes/Favs'
import Detail from './Routes/Detail';
import Template from "./Components/Template";
import { createTheme, CssBaseline, ThemeProvider } from '@mui/material';
import { ContextGlobal } from './Components/utils/global.context';

const lightTheme = createTheme({
  palette: {
    mode:'light',
  },
});

const darkTheme = createTheme({
  palette: {
    mode: 'dark',
  },
});

function App() {
  const { state } = useContext(ContextGlobal);

  return (
    <ThemeProvider theme={state.currentState === "Dark" ? darkTheme : lightTheme}>
      <CssBaseline />
      <Routes>
        <Route path="/" element={<Template />}>
          <Route path="/" element={<Home />} />
          <Route path="/contact" element={<Contact />}></Route>
          <Route path="/fav" element={<Favs />}></Route>
          <Route path="/detail/:id" element={<Detail />}></Route>
        </Route>
      </Routes>
    </ThemeProvider>
  );
}

export default App;
