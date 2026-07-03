import { AppBar, Toolbar, Typography, Button } from '@mui/material';

import HomeIcon from '@mui/icons-material/Home';
import InfoIcon from '@mui/icons-material/Info';

import { Link, useNavigate } from 'react-router-dom';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';

function NavBar() {
  const navigate = useNavigate();

  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 1 }}>
          Mi Aplicación
        </Typography>

        <Button
          color="inherit"
          component={Link}
          to="/"
          startIcon={<HomeIcon />}
        >
          Home
        </Button>

        <Button
          color="inherit"
          component={Link}
          to="/about"
          startIcon={<InfoIcon />}
        >
          Acerca de
        </Button>

        <Button
          color="inherit"
          onClick={() => navigate('/posts', { state: { fetchAt: Date.now() } })}
        >
          Posts
        </Button>
        <Button
            color="inherit"
            onClick={() => navigate('/users', { state: { fetchAt: Date.now() } })}
            startIcon={< AccountCircleIcon  />}
        >
          Users
        </Button>

      </Toolbar>
    </AppBar>
  );
}

export default NavBar;