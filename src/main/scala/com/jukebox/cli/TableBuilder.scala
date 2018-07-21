package com.jukebox.cli

sealed trait BaseTableMeta

case class TableRow(numberOfColumns: Int = 0,
                    rowDelimiter: String = "-",
                    cellList: List[TableCell]) extends BaseTableMeta

case class TableCell(cellWidth: Int = 5,
                     cellHeight: Int = 1,
                     cellContent: String = "",
                     cellDelimiter: String = "|") extends BaseTableMeta

class RowArtist extends Artist {

  def drawFirstRow(tableRow: TableRow) = {
    val maxCellHeight = tableRow.cellList.map(tc => tc.cellHeight).max
    val horizontalDelimiter = tableRow.cellList.map(tc => getDelimiter(tableRow) * tc.cellWidth).foldRight("")(_ + _)
    drawContinousAndBreak(horizontalDelimiter, 1)
    drawRowBottom(maxCellHeight, tableRow, horizontalDelimiter)
  }

  def drawNextRow(tableRow: TableRow) = {
    val maxCellHeight = tableRow.cellList.map(tc => tc.cellHeight).max
    val horizontalDelimiter = tableRow.cellList.map(tc => getDelimiter(tableRow) * tc.cellWidth).foldRight("")(_ + _)
    drawRowBottom(maxCellHeight, tableRow, horizontalDelimiter)
  }

  private def drawRowBottom(maxCellHeight: Int, tableRow: TableRow, horizontalDelimiter: String) = {
    import out.CliOutRenderer._
    maxCellHeight repeat {
      for (tableCell <- tableRow.cellList) {
        drawContinous(getDelimiter(tableCell) + (" " * tableCell.cellWidth), 1)
      }
      println()
    }
    drawContinousAndBreak(horizontalDelimiter, 1)
  }

  private def getDelimiter(tableMeta: BaseTableMeta): String = {
    tableMeta match {
      case row: TableRow => row.rowDelimiter
      case cell: TableCell => cell.cellDelimiter
      case _ => ""
    }
  }
}

abstract class Artist {
  def drawContinous(value: String, numberOfTimes: Int): Unit = {
    import out.CliOutRenderer._
    numberOfTimes repeat print(value)
  }

  def drawContinousAndBreak(value: String, numberOfTimes: Int): Unit = {
    import out.CliOutRenderer._
    numberOfTimes repeat print(value)
    println()
  }
}

