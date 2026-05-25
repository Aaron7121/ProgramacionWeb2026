import { AppBar, Toolbar, Typography, Button } from '@mui/material';

import HomeIcon from '@mui/icons-material/Home';
import InfoIcon from '@mui/icons-material/Info';

import { Link } from 'react-router-dom';

function NavBar() {
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
          component={Link}
          to="/posts"
        >
          Posts
        </Button>
      </Toolbar>
    </AppBar>
  );
}

export default NavBar;