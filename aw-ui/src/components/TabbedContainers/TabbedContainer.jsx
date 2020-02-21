import React from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import SignonForm from '../forms/SignonForm';
import RegistrationForm from '../forms/RegistrationForm';

/**
 * 
 * @param {*} props 
 */
function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <Typography
      component="div"
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && <Box p={3}>{children}</Box>}
    </Typography>
  );
}

/*
 * 
 */
TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
};

/**
 * 
 * @param {*} index 
 */
function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}

/**
 * 
 */
const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
  },
}));

/**
 * 
 */
export default function TabbedContainer() {
  const classes = useStyles();
  const [value, setValue] = React.useState(0);

  /**
   * 
   * @param {*} event 
   * @param {*} newValue 
   */
  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  let style = { width: "30%", marginLeft: "auto", marginRight: "auto", marginTop: 50 };

  return (
    <div className={classes.root} style={style}>
      <AppBar position="static">
        <Tabs value={value} onChange={handleChange} aria-label="simple tabs example">
          <Tab label="Signon" {...a11yProps(0)} />
          <Tab label="Register" {...a11yProps(1)} />
        </Tabs>
      </AppBar>
      <TabPanel value={value} index={0}>
        <SignonForm />
      </TabPanel>
      <TabPanel value={value} index={1}>
        <RegistrationForm />
      </TabPanel>
    </div>
  );
}