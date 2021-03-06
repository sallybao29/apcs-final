apcs-final
==========

Project Information
----------
Name: Puzzle-ception! :)

Group Members: Sally Bao and Xiuzhen (Tiffany) Lei 

What's the project?: A cruelly difficult escape game. Will, at times, seem as if it were intentionally made to be impossible and trying. 

To Play: java Driver

Log
----------
-12/24/14 - Added Inventory and Game files. Game.java has item information. Edited Puzzle.java - Sally

-12/26/14 - Added user input / interactions to Driver.java. Added additional item information - Tiffany

-12/26/14 - Changed AskUser to return int instead of string. Changed all user inputs to ints to make navigating arraylists easier (user inputs directly correspond to item index). Driver can compile now. Problems: Pressing return without typing anything during testing results in exception. - Sally

-12/27/14 - Fixed above problem of typing nothing or typing punctuation. Added some user input / interactions to Game.java. Added option of quitting game. - Tiffany

-12/27/14 - Added more options to interact. Laptop password is temporary until a puzzle has been made. Areas in need to work: viewing, adding, and combining things in Inventory. - Sally 

-12/27/14 - Added more items, including collectibles like Key. - Sally

-12/28/14 - Added EightGamePuzzle file. The puzzle will be included in the phone to unlock a clue. - Tiffany

-12/28/14 - Added more items, expanded on Closet. Cleaned up some formatting. - Sally

-12/28/14 - Finished EightGamePuzzle. The puzzle has been included in the phone and is now playable. Solving the puzzle permanently prevents it from appearing again, but quitting the puzzle before solving it causes a new puzzle to be generated for the next try. - Tiffany

-12/29/14 - Fixed two problems in Driver (which were causing an endless loop and an exception). Added more items. - Tiffany

-12/30/14 - Added more items. Added user interactions for the bathroom in Game.java. - Tiffany

-12/30/14 - Added doors, though they still need proper descriptions. Started checkDoor method for door interactions. Deleted some extraneous conditional statements. - Sally

-12/31/14 - Added more items. Added more interactions to use items found. - Tiffany

-12/31/14 - Added doors to list of available interactions. Made find method for inventory. - Sally

-1/1/15 - Edited Driver and checkDoor method to end the game after the last door has been opened. Added descriptions for door 2. - Tiffany

-1/1/15 - Added descriptions for notes 1 - 3, and for door 1 and 3. Made it so items that have been used will be marked in inventory. - Sally 

-1/2/15 - Added checkComp for stage 3. Fixed bookshelf + added descriptions to books. -  Sally

-1/3/15 - Fixed checkComp. Door 3 should be solvable. - Sally

-1/3/15 - Added anagram puzzle for door 4. Added descriptions for doors 4 and 5. - Tiffany

-1/6/15 - Added combine method to Inventory and toCombine method to Game. Both are implementations that allow the player to manipulate the items. - Sally

-1/7/15 - Added toUse method and edited check method. Equipping and combining items is now possible. - Sally 

-1/10/15 - Implemented point system. Added option to skip puzzles. - Sally 

-1/11/15 - Continued working on puzzle for the last door - Tiffany

-1/17/15 - Changed puzzle for last door into MineSweeper. Basic MineSweeper working. - Tiffany

-1/17/15 - Fixed EightGamePuzzle bug. - Sally

-1/18/15 - Labeled grid added to Minesweeper. Most of the connected empty squares along with most of their bordering hints appear when the user chooses an empty square connected to others. - Tiffany
