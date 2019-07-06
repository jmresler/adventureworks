import React from 'react';
import FormDialog from './components/FormDialog';
import PrimarySearchAppBar from './components/PrimarySearchAppBar';

function App() {
  return (
    <div className="App">
      <header className="App-header">
	  <PrimarySearchAppBar />
	  <FormDialog/>
      </header>
    </div>
  );
}

export default App;
