# Tutorial 2: Basics of R

#### 1)	We will start by exploring the built-in dataset called `ToothGrowth`. To find out more about this dataset, type ?ToothGrowth in the R command line. 

# - What do each of the following functions do? (Hint: You may use the Help menu or ?<function> where <function> is the function name e.g. ?summary, to find out) 

# i)	summary()
# ii)	head()
# iii) tail()
# iv)	str()

df1 <- ToothGrowth
summary(ToothGrowth)
head(ToothGrowth)
tail(ToothGrowth)
str(ToothGrowth)


#### 2)	Selecting data
# - There are several variables in `ToothGrowth`. Using Base R and dplyr functions, can you perform (i), (ii) and (iii)? 
  
# i)	Extract the column `supp`
# ii)	Extract rows where `supp` is equal to “VC” and `dose` is less than 1 and assign the output to df2
# iii) Extract the values of `len` where `supp` is equal to “VC”
# iv)	Try to perform the above operations (i, ii, iii) again but this time, assign the output to df2.1, df2.2 
#      and df2.3 respectively. 
# v)	Use the class function to check the class attribute for each of the outputs. Use is.data.frame function to check whether the output is a dataframe or a vector. 

# Type your answers below. 

#i
ToothGrowth$supp
ToothGrowth[, 2]
ToothGrowth[, 'supp']
library(dplyr)
ToothGrowth %>%
  select(supp)

#ii  
df2 <- ToothGrowth[ToothGrowth$supp == 'VC' & ToothGrowth$dose < 1,]
df2 <- subset(ToothGrowth, supp == 'VC' & dose < 1)
df2 <- ToothGrowth %>%
  filter(supp == 'VC' & dose < 1)


#iii 
ToothGrowth$len[ToothGrowth$supp == 'VC']
subset(ToothGrowth, supp == 'VC', len)
ToothGrowth %>%
  filter(supp == 'VC') %>%
  select(len)

#iv
df2.1 <- ToothGrowth$len[ToothGrowth$supp == 'VC']
df2.2 <- subset(ToothGrowth, supp == 'VC', len)
df2.3 <- ToothGrowth %>%
  filter(supp == 'VC') %>%
  select(len)

#v
class(df2.1)
class(df2.2)
class(df2.3)
is.data.frame(df2.1)
is.data.frame(df2.2)
is.data.frame(df2.3)

#### 3) Adding/Removing/Changing data columns for Toothgrowth data. 
# - i)	Change the variable name from `len` to `length` and assign the output to df3.1
# - ii)	Increase the value of len by 0.5 if supp is equal to OJ and assign the output to df3.2
# - iii) Remove the column `dose` from the data and assign the output to df3.3
# - iv) Increase the value of `dose` by 0.1 for all records and rename `dose` to `dose.new` and assign output to df3.4  
# - v) Create a new variable `high.dose` and assign it a value of "TRUE" if `dose` is more than 1 and "FALSE" if 
#   `dose` is less than or equal to 1. Assign the dataframe with the new variable `high.dose` to df3.5. 
#   Export df3.5 to a csv file. Discuss what is the r code to export as an excel file (.xlsx). 

# i
df3.1 <- ToothGrowth
colnames(df3.1)[colnames(df3.1) == "len"] <- 'length'
df3.1 <- ToothGrowth %>%
  rename(length = len)

# ii
df3.2 <- ToothGrowth
df3.2$len[df3.2[, 'supp'] == '0J'] <- df3.2$len[df3.2[, 'supp'] == '0J'] + 0.5

df3.2 <- ToothGrowth
df3.2 %>%
  mutate(len= ifelse(supp == 'OJ', len + 0.5, len))

# iii
df3.3 <- ToothGrowth[, -3]
df3.3 <- subset(ToothGrowth, select = -c(dose))
df3.3 <- ToothGrowth %>%
  select(-c(dose))

DfTest <- ToothGrowth
DfTest$dose <- NULL

# iv
df3.4 <- ToothGrowth
df3.4$dose.new <- df3.4$dose + 0.1
df3.4 <- df3.4[, -3]

df3.4 <- ToothGrowth %>%
  mutate(dose = dose+0.1) %>%
  rename(dose.new = dose)

# v
df3.5 <- ToothGrowth
df3.5$high.dose[df3.5[,'dose'] > 1] <- "TRUE"
df3.5$high.dose[df3.5[,'dose'] <= 1] <- "FALSE"

df3.5 <- ToothGrowth %>%
  mutate(high.dose = case_when(dose > 1 ~ "TRUE",
                               dose <= 1 ~ "FALSE",
                               TRUE ~ "OTHER"))
                      
write.csv(df3.5, "df3.5.csv")

#### 4) Sorting
# - i)	There are two functions in Base R “sort” and “order” to perform sorting. How do these two functions differ? 
#       Try to do a sort with each function on ToothGrowth$len.
# - ii)	Using a base R function (e.g. order), how can you sort the dataframe `ToothGrowth` in decreasing order of `len`? 
# - iii) What dplyr functions can you use to sort `ToothGrowth` in increasing order of `len`? 
#        Can you also sort the dataframe in decreasing order of `len`?  


# i
sort(ToothGrowth$len)
order(ToothGrowth$len)

# ii
ToothGrowth[order(ToothGrowth$len, decreasing = TRUE),]

# iii
ToothGrowth %>%
  arrange(len)

ToothGrowth %>%
  arrange(desc(len))


#### 5) Factors
# - i)	Check if `supp` is a factor vector. First type ToothGrowth$supp. What do you observe with the output? 
# - ii)	Next use is.factor() and is.ordered() to check if supp is a factor and if so whether it is an ordered factor. 
# - iii)	Now supposed we find that vitamin C (VC) is a superior supplement compared to orange juice (OJ), and we 
#         want to order `supp` such that VC is a higher level than OJ, how could we do this? 
  
# i
ToothGrowth$supp
  
# ii
is.factor(ToothGrowth$supp)
is.ordered(ToothGrowth$supp)

# iii
factor_supp <- factor(ToothGrowth$supp, levels=c("OJ", "VC"), ordered = TRUE)
factor_supp                



