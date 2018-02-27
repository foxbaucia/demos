import React from "react";


export default class Reload extends React.Component {
  
  render() {
    return (
      <button class="btn btn-primary" onClick={() => this.props.onClick()}>Manual Refresh</button>
    );
  }
}
