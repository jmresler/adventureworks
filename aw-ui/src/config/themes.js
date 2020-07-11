import red from '@material-ui/core/colors/red'
import pink from '@material-ui/core/colors/pink'
import green from '@material-ui/core/colors/green'
import brown from '@material-ui/core/colors/brown'
import grey from '@material-ui/core/colors/grey'

const themes = [
  {
    id: 'default',
  },
  {
    id: 'red',
    color: red[500],
    source: {
      palette: {
        primary: red,
        secondary: pink,
        error: red,
      },
    },
  },
  {
    id: 'green',
    color: green[500],
    source: {
      palette: {
        primary: green,
        secondary: red,
        error: red,
      },
    },
  },
  {
    id: 'brown',
    color: brown[500],
    source: {
      palette: {
        primary: brown,
        secondary: red,
        error: red,
      },
    },	
  },

  {

    id: 'grey',
    color: grey[500],
    source: {
      palette: {
        primary: grey,
        secondary: brown,
        error: red,
  	}
    }
  }
]

export default themes
