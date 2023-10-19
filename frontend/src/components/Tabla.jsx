import React from 'react'
import Table from 'react-bootstrap/Table';

const TableResponsive = ({headers,datos}) => {
  return (
    <div>
      <Table responsive="sm">
        <thead>
          <tr>
            {/* <th>#</th> */}
            <th>Rut</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Table heading</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            {/* <td>1</td> */}
            <td>Table cell</td>
            <td>Table cell</td>
            <td>Table cell</td>
            <td>Table cell</td>
          </tr>
          <tr>
            {/* <td>2</td> */}
            <td>Table cell</td>
            <td>Table cell</td>
            <td>Table cell</td>
            <td>Table cell</td>
          </tr>
          <tr>
            {/* <td>3</td> */}
            <td>Table cell</td>
            <td>Table cell</td>
            <td>Table cell</td>
            <td>Table cell</td>
          </tr>
        </tbody>
      </Table>
    </div>
  )
}

export default TableResponsive
