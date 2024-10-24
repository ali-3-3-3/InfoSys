# Tutorial 2: Basics of R"

### PART 2 (15 marks)
# For this part of the tutorial, you will be using the built-in dataset `trees`.
# This dataset provides measurements of the diameter, height and volume of timber in 31 felled black cherry trees. 
# Note that the diameter (in inches) is erroneously labelled Girth in the data. It is measured at 4 ft 6 in above the ground.

# The 3 variables are defined as follows:
  
# - Girth: Tree diameter (rather than girth, actually) in inches
# -	Height: Height in ft
# - Volume: Volume of timber in cubic ft

#### 1) Inspect the dataset (2 marks)
# - Use the functions you have learnt in Part 1 of this tutorial to inspect the dataset. 
# Describe this dataset in terms of the number of observations, number of variables, and type of variables. 

summary(trees)
head(trees)
tail(trees)
str(trees)

Number_of_observations = 31 ### nrow()
Number_of_variables = 3 ### ncol()
Type_of_variables = class(trees$Girth)

#### 2) Data Extraction (6 marks)
# - i) Assign the dataset `trees` to `dft` (Note: O is the capital letter of o and not the number zero) 
# - ii)	Extract the columns `Height` and `Volume` from `dft` and assign it to `dft2ii`. 
#        Export `dft2ii` as a csv file.(2 marks)
# - iii) Using Base R functions, extract the rows from `dft` where `Volume` is greater than 22. 
#        How many rows are extracted? 
# - iv) Using dplyr functions, remove the `Volume` column and retain only the rows where  `Girth` is greater than 12 
#       and Height is less than 78 and assign this output to `dft2iv`. How many observations are there in `dft2iv`?[2 marks)

#i
dft <- trees

#ii
dft2ii <- dft[c("Height", "Volume")]
### dft[, c(2,3)] also correct! Data frame[row, column]
write.csv(dft2ii, "dft2ii.csv")

#iii
dft2iii <- subset(dft$Volume, dft$Volume > 22)
Number_of_rows = 18
### subset(dft, Volume > 22)
### nrow(dft[dft$Volume>22, ])

#iv
library(dplyr)
dft2iv <- dft %>%
  select(-c("Volume")) %>%
  filter(Girth > 12) %>%
  filter(Height < 78) ## filter(Girth > 12 && Height < 78)
Number_of_observations = 6 ### nrow()

#### 3) Variables (4 marks)
# - i) Rename the variable in `dft` from `Girth` to `Diameter`
# - ii) Convert the values in `Diameter` from inches to centimeters [hint: 1 inch = 2.54cm]
# - iii) Create a new *factor* variable in `dft` called `Size`. `Size` is an ordered factor with two values "Small"
#       and "Large". Trees are considered "Large" if their volume is larger than 30 or height is greater than 80, 
#       otherwise they are considered "Small". Assign the values to the variable `Size` based on this definition. (2 marks)

# You may use dplyr or base R functions for this question part. 

library(dplyr)

#i
dft %>%
  rename(Diameter = Girth)

#ii
dft %>%
  rename(Diameter = Girth) %>%
  mutate(Diameter / 2.54)
###dft$Diameter <- dft$Diameter*2.54

#iii
dft$Size <- ifelse(trees$Volume > 30 | trees$Height > 80, "Large", "Small")
Size <- factor(dft$Size) ### need to add levels & ordered
is.factor(Size)
### dft$Size <- "Small"
### dft$Size(dft$Height > 80 | dft$Volume > 30) <- "Large"
### dft$Size <- factor(dft$Size, levels=c("Small", "Large"), ordered = TRUE)

#### 4) Sorting (3 marks)
# - i)	Using base R, sort `dft` in increasing order of `Size`. How many large and small trees are there? 
# - ii)	Using dplyr, sort `dft` in decreasing order of `Size` followed by decreasimg order of `Volume`. The output 
#    should have the observations arranged in decreasing order of Size first and within the same level of Size, 
#   the observations should be arranged in decreasing order of Volume. (2 marks)

#i
dft1 <- dft[order(Size, decreasing = TRUE), ]
Small_Trees <- sum(with(dft1,Size == "Small"))
Large_Trees <- sum(with(dft1,Size == "Large"))

#ii
library(dplyr)
dft1 %>%
  arrange(dft1$Size, desc(dft1$Volume))
 ### arrange(desc(Size), desc(Volume))

