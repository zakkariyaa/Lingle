package com.example.lingle.utils

import com.example.lingle.R

val categories = listOf(
    Category(
        name = "Fruits",
        picture = R.drawable.fruits,
        items = arrayListOf(
            Item("Apple", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/1_kjyk3h.png"),
            Item("Pear", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/5_qbaizz.png"),
            Item("Orange", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/2_ymvg5d.png"),
            Item("Strawberry", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/3_kiv5du.png"),
            Item("Banana", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393272/4_w6aicq.png"),
            Item("Grapes", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393950/6_iohv8w.png"),
            Item("Watermelon", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393950/7_tuehcc.png"),
            Item("Pineapple", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393950/8_yhzzms.png"),
            Item("Kiwi", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393951/9_jjzifm.png"),
            Item("Cherries", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702393951/10_hwcywt.png")
        ),
    ),
    Category(
        name = "Vegetables",
        picture = R.drawable.vegetables,
        items = arrayListOf(
            Item("Sweetcorn", "https://www-leshop-ch-cld-res.cloudinary.com/image/upload/w_1000,h_1000,d_mo-default-product-detail.png,c_pad,g_center,fl_lossy,b_rgb:fff/f_auto/e_unsharp_mask:99/q_auto/v1458121117/prod/catalog/product/product-66226"),
            Item("Carrot", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702395495/carrot_fqdbll.png"),
            Item("Mushroom", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702395935/mushroom-cartoon-drawing-on-white-two-brown-cute-mushrooms-icon-for-design-vector_ncbbvp.jpg"),
            Item("Lettuce", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702395571/lettuce_cnrbpj.png"),
            Item("Tomato", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702395863/tomato_sia2um.png"),
            Item("Cucumber", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702396179/13_ofgazc.png"),
            Item("Broccoli", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702396179/12_uaiplv.png"),
            Item("Pepper", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702396179/11_bka9m3.png"),
            Item("Cauliflower", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702396820/648404f8e2d92ea80491d6830560d6de_i125r8.png"),
            Item("Pumpkin", "https://res.cloudinary.com/dqgeypwaa/image/upload/v1702397749/pumpkin-isolated-on-white-background-cartoon-vector-26775102_qbqywi.jpg")
        )
    ),
    Category(
        name = "Animals",
        picture = R.drawable.animals,
        items = arrayListOf(
            Item("Dog", "https://i.pinimg.com/originals/64/54/45/645445b5e8d68fc2701da573fc692357.png"),
            Item("Cat", "https://i.pinimg.com/736x/3b/90/18/3b901845141de8da9ba17f2c94eb3e1e.jpg"),
            Item("Elephant", "https://static.vecteezy.com/system/resources/previews/007/270/801/original/cartoon-elephant-isolated-on-white-background-vector.jpg"),
            Item("Lion", "https://i.pinimg.com/564x/2a/8a/64/2a8a6425941b9ee64fc3bf911f87134a.jpg"),
            Item("Giraffe", "https://img.freepik.com/premium-vector/giraffe-cartoon-animal-illustration_7814-716.jpg?w=2000"),
            Item("Monkey", "https://img.freepik.com/premium-vector/cute-monkey-cartoon_146562-7.jpg"),
            Item("Penguin", "https://static.vecteezy.com/system/resources/previews/025/024/730/original/cute-penguin-isolated-on-transparent-background-ai-generated-digital-illustration-png.png"),
            Item("Dolphin", "https://www.shutterstock.com/image-vector/purple-dolphin-adorable-marine-mammal-600nw-2385499475.jpg"),
            Item("Tiger", "https://static.vecteezy.com/system/resources/previews/005/161/881/non_2x/cartoon-tiger-on-white-background-free-vector.jpg"),
            Item("Horse", "https://static.vecteezy.com/system/resources/previews/024/044/184/original/horse-icon-clipart-transparent-background-free-png.png")
        )
    ),

    Category(
        name = "Colours",
        picture = R.drawable.colours,
        items = arrayListOf(
            Item("Red", "https://www.solidbackgrounds.com/images/3840x2160/3840x2160-red-solid-color-background.jpg"),
            Item("Blue", "https://htmlcolorcodes.com/assets/images/colors/bright-blue-color-solid-background-1920x1080.png"),
            Item("Green", "https://htmlcolorcodes.com/assets/images/colors/bright-green-color-solid-background-1920x1080.png"),
            Item("Yellow", "https://htmlcolorcodes.com/assets/images/colors/yellow-color-solid-background-1920x1080.png"),
            Item("Orange", "https://www.solidbackgrounds.com/images/1920x1080/1920x1080-amber-orange-solid-color-background.jpg"),
            Item("Purple", "https://htmlcolorcodes.com/assets/images/colors/purple-color-solid-background-1920x1080.png"),
            Item("Pink", "https://htmlcolorcodes.com/assets/images/colors/pastel-pink-color-solid-background-1920x1080.png"),
            Item("Brown", "https://htmlcolorcodes.com/assets/images/colors/light-brown-color-solid-background-1920x1080.png"),
            Item("Black", "https://htmlcolorcodes.com/assets/images/colors/black-color-solid-background-1920x1080.png"),
//            Item("White", "https://htmlcolorcodes.com/assets/images/colors/white-color-solid-background-1920x1080.png")
        )
    )
)
