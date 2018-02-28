import React from "react";


export default class ListTitle extends React.Component {

  render() {
  	const _titles = this.props.titles.map((aTitle, index) => {
       return (
          <th key={index}>{aTitle}</th>
      );
    });
    return (
      <thead>
        <tr>
          {_titles}
        </tr>
      </thead>

    );
  }
}
