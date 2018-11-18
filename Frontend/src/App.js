import React, { Component } from 'react';

import Ladder from './Ladder/';

const response = require('./Ladder/response.json');

class App extends Component {
  render() {
    return (
      <div>
        <Ladder response={response}/>
      </div>
    );
  }
}

export default App;
