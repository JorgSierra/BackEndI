import { Button, Dialog, DialogActions, DialogContent, DialogTitle, FormControl, FormGroup, FormHelperText, Input, InputLabel, Typography } from '@mui/material'
import React, { Fragment, useState } from 'react'
import SendIcon from '@mui/icons-material/Send';
import { useEffect } from 'react';


const Form = () => {
  //Aqui deberan implementar el form completo con sus validaciones

  const [inputValues, setInputValues] = useState('');
  const [nameIsValid, setNameIsValid] = useState(true);
  const [emailIsValid, setEmailIsValid] = useState(true);
  const [disabledButton, setdisabledButton] = useState(true);
  const [open, setOpen] = useState(false);


  const nameValidation = (e) => {
    if (e.target.value.length >= 1 && e.target.value.length <= 5) {
      setNameIsValid(false)
    }
    else {
      setNameIsValid(true);
      setInputValues(e.target.value)
    }
  }

  const emailValidation = (e) => {
    const reg = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/
    const text = e.target.value;
    const result = reg.test(text);

    if (!result && e.target.value.length) {
      setEmailIsValid(false)
    }
    else {
      setEmailIsValid(true)
    }
  }

  useEffect(() => {
    if (nameIsValid && emailIsValid) {
      setdisabledButton(false);
    }
    else {
      setdisabledButton(true);
    }
  }, [nameIsValid, emailIsValid])

  const handleClickOpen = () => {
    setOpen(true)
  }

  const handleClose = () => {
    setOpen(false);
  };

  useEffect(() => {
    const inputName = document.querySelector('#name').value;
    const inputEmail = document.querySelector('#email').value;
    if (inputName === '' || inputEmail === '') {
      setdisabledButton(true)
    }
  }, [nameIsValid, emailIsValid])


  return (
    <Fragment>
      <Typography variant='h4' sx={{ marginTop: '20px' }}>{'Contact'}</Typography>
      <FormGroup sx={{ width: '300px', marginTop: '20px', gap: '10px', height:'40vh'}}>
        <FormControl>
          <InputLabel error={!nameIsValid}>{nameIsValid ? 'Full name' : 'Error'}</InputLabel>
          <Input
            id='name'
            error={!nameIsValid}
            name='Full name'
            onChange={(e) => nameValidation(e)}
          />
          <FormHelperText error={!nameIsValid}>{nameIsValid ? '' : 'El nombre debe contener mas de 5 letras'}</FormHelperText>
        </FormControl>
        <FormControl>
          <InputLabel error={!emailIsValid}>{emailIsValid ? 'Email' : 'Error'}</InputLabel>
          <Input
            id='email'
            error={!emailIsValid}
            name='Email'
            coomponent='email'
            onChange={(e) => emailValidation(e)}
          />
          <FormHelperText error={!emailIsValid}>{emailIsValid ? '' : 'Debe ingresar un correo valido'}</FormHelperText>
        </FormControl>
        <Button disabled={disabledButton} onClick={handleClickOpen} variant="contained" endIcon={<SendIcon />}>Send</Button>
      </FormGroup>

      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>{`${inputValues} te contactaremos lo antes posible via email`}</DialogTitle>
        <DialogContent>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Aceptar</Button>
        </DialogActions>
      </Dialog>

    </Fragment>
  );
};

export default Form;
