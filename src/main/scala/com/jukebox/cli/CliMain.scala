package com.jukebox.cli

object CliMain {

  def main(args: Array[String]): Unit = {
    val rowArtist = new RowArtist()
    val normalCell = TableCell()
    val smallCell = TableCell()
    val cellList: List[TableCell] = List(smallCell.copy(cellContent = "abc"), normalCell.copy(cellContent = "efg55gcvbrun"), normalCell.copy(cellContent = "1234"), normalCell, normalCell)
    rowArtist.drawHeaderRow(TableRow(numberOfColumns = 5,rowHeight=2, cellList = cellList))
    rowArtist.drawNextRow(TableRow(numberOfColumns = 5,cellList = cellList))
  }

}
