# Final project: FishGo

## Description
Fish MinMin lives in the sea. She can move from left to right.

Sticks are generated randomly. Players should help MinMin avoid sticks.
If she hits a stick, she'll lose one life. She has 3 lives in total.

Starfishes are generated randomly. Players should help MinMin eat more starfishes.
There are 2 kinds of Starfishes, a small yellow starfish worthes 1 point, a large red starfish worthes 2 points.

Players can press ↑ to make MinMin move up and ↓ to move down. 
Once she reaches top of the game window, she will come to the bottom.
Once she reaches bottom of the game window, she will come to the top.

Players can press → to make MinMin accelerate and ← to decelerate.
MinMin can only move from left to right, the direction can't be changed.
The speed has upper bound and lower bound. Once reaches these bound, the speed won't change when pressing → or ←.
Once she reaches right layer of the game window, she will come to the left.

Player's goal is to last longer and gain more points.
When game is over, player can press space to restart the game.

## Files
models: elements used in the game.
ImagePool loads all images needed and SoundPool loads all sound.
Timer record the time of the game.
Fish, Stick, Starfish are basic elements in the game.

view:
DrawUtil provide several methods that draw graph on the frame.

controller:
GameLayer combines fish, sticks, starfishes together. 
It generates sticks and starfishes randomly 
and also detect crashes between fishes and sticks, fishes and starfishes.
FrameControl draw the basic frame (with help of methods in DrawUtil in View) 
and add KeyListener to control the game.
Game is the entrance to play the game.


## Entrance of game
Run Game.java in controller to play the game.

