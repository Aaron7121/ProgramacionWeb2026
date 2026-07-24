import {AppBar, Button, Toolbar, Typography} from "@mui/material";
import {Link} from "react-router-dom";



function NavBar (){
    return(


        <AppBar position={"static"}>
            <Toolbar >
                <Typography sx={{flexGrow:1}}>

                    <p>Hola app</p>


                </Typography>
                <Button  variant={"contained"} color={"primary"} component={Link} to="/test" >HOME</Button>
                <Button  variant={"contained"} color={"primary"} component={Link} to="/clientes">CLIENTES</Button>



            </Toolbar>


        </AppBar>
    )

}export default NavBar