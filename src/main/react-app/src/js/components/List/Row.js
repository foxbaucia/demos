import React from "react";


export default class Row extends React.Component {
  render() {
    return (
      <tr>
        <td>{this.props.item.name}</td>
        <td>{this.props.item.hits}</td>
      </tr>
    );
  }
}
