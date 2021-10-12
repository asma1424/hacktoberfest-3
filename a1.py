
def show_menu():
            print("=================================================")
            print("              MY BAZAAR                          ")
            print("=================================================")
            print("Hello! Welcome to my grocery store!")
            print("Following are the products available in the shop:")
            print("-------------------------------------------------")
            print("CODE | DESCRIPTION |   CATEGORY   | COST (Rs)    ")
            print("-------------------------------------------------")
            print("0    | Tshirt      | Apparels     | 500")
            print("1    | Trousers    | Apparels     | 600")
            print("2    | Scarf       | Apparels     | 250")
            print("3    | Smartphone  | Electronics  | 20,000")
            print("4    | iPad        | Electronics  | 30,000")
            print("5    | Laptop      | Electronics  | 50,000")
            print("6    | Eggs        | Eatables     | 5")
            print("7    | Chocolate   | Eatables     | 10")
            print("8    | Juice       | Eatables     | 100")
            print("9    | Milk        | Eatables     | 45")
            print("------------------------------------------------")
            print("Would you like to buy in bulk? (y or Y / n or N)")
          


def get_regular_input():
            print("-------------------------------------------------")
            print("ENTER ITEMS YOU WISH TO BUY")
            print("-------------------------------------------------")
            lst = [int(item) for item in input("Enter the item codes (space-separated): ").split()]
            quantities=[]
            quantities=lst
            a=0
            b=0
            c=0
            d=0
            e=0
            f=0
            g=0
            h=0
            l=0
            j=0
            for i in quantities:
                if i==0:
                    a=a+1
                    
            for i in quantities:
                if i==1:
                    b=b+1
                    
            for i in quantities:
                if i==2:
                    c=c+1
            for i in quantities:
                if i==3:
                    d=d+1
            for i in quantities:
                if i==4:
                    e=e+1
            for i in quantities:
                if i==5:
                    f=f+1
            for i in quantities:
                if i==6:
                    g=g+1
            for i in quantities:
                if i==7:
                    h=h+1
            for i in quantities:
                if i==8:
                    j=j+1
            for i in quantities:
                if i==9:
                    l=l+1
            for i in range(0,len(lst)):
                if lst[i]<0:
                    print(lst[i],"is invalid input")
            for i in range(0,len(lst)):
                if lst[i]>9:
                    print(lst[i],"is invalid input")
                    
            quantities=[a,b,c,d,e,f,g,h,j,l]
            
            lst=quantities
            return lst                            


def get_bulk_input():
    
    print("-------------------------------------------------")
    print("ENTER ITEMS YOU WISH TO BUY")
    print("-------------------------------------------------")
    p=[]
    lst=[]
    f1=1
    a=0
    b=0
    c=0
    d=0
    e=0
    f=0
    g=0
    h=0
    j=0
    l=0
    while f1>0:
        p= [int(item) for item in input("Enter code and quantity (leave blank to stop): ").split()]
        
        if len(p)==0:
            f1=0
            break
        if len(p)==2:
            
            for x in range(len(p)): 
                p1=p[0]
                p2=p[1]
            
                
            if p1==0 and p2>0:
                print("You added", p2,"Tshirt")
                a=p2
                
            if p1==1 and p2>0:
                print("You added", p2,"Trousers")
                b=p2
                
                     
            if p1==2 and p2>0:
                print("You added", p2,"Scarf")
                c=p2
                
            if p1==3 and p2>0:
                print("You added", p2,"Smartphone")
                d=p2
                
            if p1==4 and p2>0:
                print("You added", p2,"iPad")
                e=p2
                
            if p1==5 and p2>0:
                print("You added", p2,"Laptop")
                f=p2
                
            if p1==6 and p2>0:
                print("You added", p2,"Eggs")
                g=p2
                
            if p1==7 and p2>0:
                print("You added", p2,"Chocolate")
                h=p2
                
            if p1==8 and p2>0:
                print("You added", p2,"Juice")
                l=p2
                
            if p1==9 and p2>0:
                print("You added", p2,"Milk")
                j=p2
                
            if p1<0 or p1>9:
                print("Invalid code. Try again")
            if p2<0:
                print("Invalid quantity. Try again")
        else:
            print("Invalid Input. Try Again")
    
            
        
    print("Your order has been finalized.")
    lst=[a,b,c,d,e,f,g,h,j,l]
    return lst

    
        
def print_order_details(quantities):
    a=1
    b=1
    c=1
    d=1
    e=1
    f=1
    g=1
    h=1
    l=1
    j=1
    print("-------------------------------------------------")
    print("ORDER DETAILS")
    print("-------------------------------------------------")
    for i in range(0,1):
        if quantities[i]>0:
            a=quantities[i]*500
            print("[1] Tshirt x ",quantities[i],"= Rs 500 *", quantities[i]," = Rs" ,a)
    for i in range(1,2):
        if quantities[i]>0:
            b=quantities[i]*600
            print("[2] Trousers x ",quantities[i],"= Rs 600 *", quantities[i]," = Rs" ,b)
    for i in range(2,3):
        if quantities[i]>0:
            c=quantities[i]*250
            print("[3] Scarf x ",quantities[i],"= Rs 250 *", quantities[i]," = Rs" ,c)
    for i in range(3,4):
        if quantities[i]>0:
            d=quantities[i]*20000
            print("[4] Smartphone x ",quantities[i],"= Rs 20000 *", quantities[i]," = Rs" ,d)
    for i in range(4,5):
        if quantities[i]>0:
            e=quantities[i]*30000
            print("[5] iPad x ",quantities[i],"= Rs 30000 *", quantities[i]," = Rs" ,e)
    for i in range(5,6):
        if quantities[i]>0:
            f=quantities[i]*50000
            print("[6] Laptop x ",quantities[i],"= Rs 50000 *", quantities[i]," = Rs" ,f)
    for i in range(6,7):
        if quantities[i]>0:
            g=quantities[i]*5
            print("[7] Eggs x ",quantities[i],"= Rs 5 *", quantities[i]," = Rs" ,g)
    for i in range(7,8):
        if quantities[i]>0:
            h=quantities[i]*10
            print("[8] Chocolate x ",quantities[i],"= Rs 10 *", quantities[i]," = Rs" ,h)
    for i in range(8,9):
        if quantities[i]>0:
            j=quantities[i]*100
            print("[9] Juice x ",quantities[i],"= Rs 100 *", quantities[i]," = Rs" ,j)
    for i in range(9,10):
        if quantities[i]>0:
            l=quantities[i]*45
            print("[10] Milk x ",quantities[i],"= Rs 45 *", quantities[i]," = Rs" ,l)
    
    
    
    
def calculate_category_wise_cost(quantities):
    a=0
    b=0
    c=0
    d=0
    e=0
    f=0
    g=0
    h=0
    l=0
    j=0
    for i in range(0,1):
        if quantities[i]>0:
            a=quantities[i]*500
            
    for i in range(1,2):
        if quantities[i]>0:
            b=quantities[i]*600
            
    for i in range(2,3):
        if quantities[i]>0:
            c=quantities[i]*250
            
    for i in range(3,4):
        if quantities[i]>0:
            d=quantities[i]*20000
            
    for i in range(4,5):
        if quantities[i]>0:
            e=quantities[i]*30000
            
    for i in range(5,6):
        if quantities[i]>0:
            f=quantities[i]*50000
            
    for i in range(6,7):
        if quantities[i]>0:
            g=quantities[i]*5
            
    for i in range(7,8):
        if quantities[i]>0:
            h=quantities[i]*10
            
    for i in range(8,9):
        if quantities[i]>0:
            j=quantities[i]*100
            
    for i in range(9,10):
        if quantities[i]>0:
            l=quantities[i]*45
            

    Apparels =a+b+c
    Electronics =d+e+f
    Eatables=g+h+j+l
    print("-------------------------------------------------")
    print("CATEGORY-WISE COST")
    print("-------------------------------------------------")
    if Apparels>0:
        print("Apparels = Rs ",Apparels)
    if Electronics>0:
        print("Electronics = Rs ",Electronics)
    if Eatables>0:
        print("Eatables = Rs ",Eatables)
    return Apparels,Electronics,Eatables

    

def get_discount(cost, discount_rate):
    
    return int(cost * discount_rate)


def calculate_discounted_prices(apparels_cost, electronics_cost, eatables_cost):
    print("-------------------------------------------------")
    print("DISCOUNT")
    print("-------------------------------------------------")
    a1=0
    b1=0
    c1=0
    a2=0
    b2=0
    c2=0
    z=apparels_cost+electronics_cost+eatables_cost
    if apparels_cost>=2000:
        a1=apparels_cost-get_discount(apparels_cost,0.1)
        a2=get_discount(apparels_cost,0.1)
        print("[APPAREL] Rs",apparels_cost, " - Rs",get_discount(apparels_cost,0.1), "= Rs",a1)
    if electronics_cost>=25000:
        b1=electronics_cost-get_discount(electronics_cost,0.1)
        b2=get_discount(electronics_cost,0.1)
        print("[ELECTRONICS] Rs",electronics_cost, " - Rs",get_discount(electronics_cost,0.1), "= Rs",b1)
    if eatables_cost>500:
        c1=eatables_cost-get_discount(eatables_cost,0.1)
        c2=get_discount(eatables_cost,0.1)
        print("[EATABLES] Rs",eatables_cost, " - Rs",get_discount(eatables_cost,0.1), "= Rs",c1)
    if apparels_cost<2000 and electronics_cost<25000 and eatables_cost<=500:

        a1=apparels_cost
        b1=electronics_cost
        c1=eatables_cost
    if apparels_cost<2000:
        a1=apparels_cost
    if electronics_cost<25000:
        b1=electronics_cost
    if eatables_cost<=500:
        c1=eatables_cost
        
    
        
        
    print('\n')
    print("TOTAL DISCOUNT=",a2+b2+c2)
    print("TOTAL COST=",a1+b1+c1)
    apparels_cost=a1
    electronics_cost=b1
    eatables_cost=c1
    return apparels_cost,electronics_cost,eatables_cost
    

def get_tax(cost, tax):
    
    return int(cost * tax)


def calculate_tax(apparels_cost, electronics_cost, eatables_cost):
    print("-------------------------------------------------")
    print("TAX")
    print("-------------------------------------------------")
    a1=apparels_cost
    b1=electronics_cost
    c1=eatables_cost
    a2=0
    b2=0
    c2=0
    a2=get_tax(a1,0.10)
    b2=get_tax(b1,0.15)
    c2=get_tax(c1,0.05)
    print("[APPAREL] Rs",a1," * 0.10 = Rs",a2)
    print("[ELECTRONICS] Rs",b1," * 0.15 = Rs",b2)
    print("[EATABLES] Rs",c1," * 0.05 = Rs",c2)
    print("\n")
    print("TOTAL TAX= Rs",a2+b2+c2)
    z1=a2+b2+c2
    print("TOTAL COST= Rs",(a1+b1+c1)+(a2+b2+c2))
    TC=(a1+b1+c1)+(a2+b2+c2)
    return TC,z1
        


def apply_coupon_code(total_cost):
    print("-------------------------------------------------")
    print("COUPON CODE")
    print("-------------------------------------------------")
    d1=min(5000,0.25*total_cost)
    d2=min(10000,0.5 * total_cost)
    x=input("Enter coupon code (else leave blank):")
    if x=="HELLE25" and total_cost>=25000:
        print("[HELLE25] min(5000, Rs 0.25 *",total_cost,")"," = Rs", d1)
        total_cost=total_cost-d1
        print("\n")
        print("TOTAL COUPON DISCOUNT = Rs", d1)
        print("TOTAL COST = Rs",total_cost)
        return total_cost,d1
    if x=="CHILL50" and total_cost>=50000:
        print("[CHILL50] min(10000, Rs 0.50 *",total_cost,")"," = Rs", d2)
        total_cost=total_cost-d2
        print("\n")
        print("TOTAL COUPON DISCOUNT = Rs", d2)
        print("TOTAL COST = Rs",total_cost)
        return total_cost,d2
    if x=="":
        print("No coupon code applied.")
        print("\n")
        print("TOTAL COUPON DISCOUNT = Rs 0")
        print("TOTAL COST = Rs",total_cost)
        return total_cost,0
    else:
        print("Invalid coupon code. Try again.")
        print("\n")
        print("Enter coupon code (else leave blank):")
        x=input()
        if x=="":
            print("No coupon code applied.")
            print("\n")
            print("TOTAL COUPON DISCOUNT = Rs 0")
            print("TOTAL COST = Rs",total_cost)
            return total_cost,0
    
    
        


def main():
    show_menu()
    check=0
    while check==0:
        w=input()
        if w=="n"or w=="N":
            quantities=[]
            lst=[]
            quantities=get_regular_input()
            lst=quantities
            print('\n')
            print_order_details(lst)
            Apparels,Electronics,Eatables=calculate_category_wise_cost(lst)
            print('\n')
            Apparels,Electronics,Eatables=calculate_discounted_prices(Apparels,Electronics,Eatables)
            print("\n")
            tc=calculate_tax(Apparels,Electronics,Eatables)[0]
            print("\n")
            apply_coupon_code(tc)
            print("\n")
            print("Thank you for visiting!")
            check=1
        elif w=="y"or w=="Y":
            quantities=[]
            lst=[]
            quantities=get_bulk_input()
            lst=quantities
            print('\n')
            print_order_details(lst)
            Apparels,Electronics,Eatables=calculate_category_wise_cost(lst)
            print('\n')
            Apparels,Electronics,Eatables=calculate_discounted_prices(Apparels,Electronics,Eatables)
            print("\n")
            tc=calculate_tax(Apparels,Electronics,Eatables)[0]
            print("\n")
            apply_coupon_code(tc)
            print("\n")
            print("Thank you for visiting!")
            check=1
        else:
            print("Enter Valid Input")
    

if __name__ == '__main__':
    main()
    
