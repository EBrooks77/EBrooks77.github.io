# Software Design and Engineering

The artifact I selected for the software engineering and design prompt was the final project from one of my earliest classes. This project use java to create a slideshow of vacation locations as part of a travel business’ marketing strategy. I chose this piece of code because it was simple, straightforward, and met its base purpose but could be improved to do all of those things better. 

The first change was a small one. The original coloring of the slideshow boxes was a dark blue that did not mix well with the images being presented. I updated this color to better suit the marketing focus of the slideshow. 

The second change is more involved. I added in a timer function to swap to the next slide after 6 seconds even if the next button is not clicked. This allows for cycling through the slides without having to interact. This also serves a marketing purpose by showing more vacation destinations without any action needed.

There may be more work needed to make sure that the timer functionality is consistent. I found while working on this that sometimes the timing gets messed up if you click to the next slide in the middle of the timer. For example, if you manually change the slide during the 4th second, it might change again 2 seconds later. More work will need to be done to iron out that issue. Looping the slideshow back to the first slide would be another improvement. That way the automation of the slides doesn’t simply shorten the time that the slides are being viewed.

[Slide Show zip](https://github.com/EBrooks77/EBrooks77.github.io/blob/main/ErinBrooks_CS499_SoftwareDesignEngineering/ErinBrooks_CS499_Slideshow.zip)
