document.write(`
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">

        <a class="navbar-brand" href="/">Clinica Muelitas</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Odontologos
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/odontologo_post.html">Registrar</a></li>
                        <li><a class="dropdown-item" href="/odontologo_list.html">Listar</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Pacientes
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/paciente_post.html">Registrar</a></li>
                        <li><a class="dropdown-item" href="/paciente_list.html">Listar</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Turnos
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/turno_post.html">Registrar</a></li>
                        <li><a class="dropdown-item" href="/turno_list.html">Listar</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
`);