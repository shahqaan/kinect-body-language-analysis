# kinect-body-language-analysis

Uses Kinect to study human motion, does emotional analysis and generates music based on user's emotion.

You can find the code documented over here: [Kinect Body Language Analysis](http://shahqaan.github.io/kinect-body-language-analysis/annotated.html)

<span class="c4 c8">[1](#h.tyjcwt)</span><span class="c4 c8">[INTRODUCTION](#h.tyjcwt)</span>

<span class="c4 c8">[1.1](#h.3dy6vkm)</span><span class="c4 c8">[DEFINING ART AND HUMAN MOTIONS](#h.3dy6vkm)</span>

<span class="c4 c8">[1.2](#h.1t3h5sf)</span><span class="c4 c8">[IMPORTANCE](#h.1t3h5sf)</span>

<span class="c4 c8">[1.3](#h.2s8eyo1)</span><span class="c4 c8">[PROJECT GOAL](#h.2s8eyo1)</span>

<span class="c4 c8">[2](#h.17dp8vu)</span><span class="c4 c8">[Literature Review](#h.17dp8vu)</span>

<span class="c4 c8">[2.1](#h.26in1rg)</span><span class="c4 c8">[Human Motion Analysis](#h.26in1rg)</span>

<span class="c4 c8">[2.1.1](#h.lnxbz9)</span><span class="c4 c8">[Recognition and Re-synthesis of Human Motion with Personalized Variations](#h.lnxbz9)</span>

<span class="c4 c8">[2.1.2](#h.35nkun2)</span><span class="c4 c8">[3D Human Action Recognition and Style Transformation Using Resilient Back propagation Neural Networks](#h.35nkun2)</span>

<span class="c4 c8">[2.1.3](#h.1ksv4uv)</span><span class="c4 c8">[Conclusion](#h.1ksv4uv)</span>

<span class="c4 c8">[2.2](#h.44sinio)</span><span class="c4 c8">[Color Detection and Optimization](#h.44sinio)</span>

<span class="c4 c8">[2.2.1](#h.2jxsxqh)</span><span class="c4 c8">[Aesthetic Coloring for Complex Layout Using Genetic Algorithm](#h.2jxsxqh)</span>

<span class="c4 c8">[2.2.2](#h.z337ya)</span><span class="c4 c8">[Conclusion](#h.z337ya)</span>

<span class="c4 c8">[2.3](#h.3j2qqm3)</span><span class="c4 c8">[Psychological Analysis of Human Motion](#h.3j2qqm3)</span>

<span class="c4 c8">[2.3.1](#h.1y810tw)</span><span class="c4 c8">[Affective States](#h.1y810tw)</span>

<span class="c4 c8">[2.3.2](#h.4i7ojhp)</span><span class="c4 c8">[Difference between Emotion and Mood](#h.4i7ojhp)</span>

<span class="c4 c8">[2.3.3](#h.2xcytpi)</span><span class="c4 c8">[Arousal, Valence and Stance](#h.2xcytpi)</span>

<span class="c4 c8">[2.3.4](#h.1ci93xb)</span><span class="c4 c8">[Gesture](#h.1ci93xb)</span>

<span class="c4 c8">[2.3.5](#h.3whwml4)</span><span class="c4 c8">[GEMEP](#h.3whwml4)</span>

<span class="c4 c8">[2.3.6](#h.2bn6wsx)</span><span class="c4 c8">[Importance of Body Language Analysis](#h.2bn6wsx)</span>

<span class="c4 c8">[2.3.7](#h.qsh70q)</span><span class="c4 c8">[Survey](#h.qsh70q)</span>

<span class="c4 c8">[2.4](#h.3as4poj)</span><span class="c4 c8">[The Role of Spatial and Temporal Information in Biological Motion Perception.pdf](#h.3as4poj)</span>

<span class="c4 c8">[2.5](#h.1pxezwc)</span><span class="c4 c8">[Evidence for Distinct Contributions of Form and Motion Information to the Recognition of Emotions from Body Gestures.pdf](#h.1pxezwc)</span>

<span class="c4 c8">[2.6](#h.49x2ik5)</span><span class="c4 c8">[Visual Perception of Expressiveness in Musician's Body Movements.pdf](#h.49x2ik5)</span>

<span class="c4 c8">[2.7](#h.2p2csry)</span><span class="c4 c8">[Automated Analysis of Body Movement in Emotionally Expressive Piano Performances.pdf](#h.2p2csry)</span>

<span class="c4 c8">[2.7.1](#h.147n2zr)</span><span class="c4 c8">[Conclusions:](#h.147n2zr)</span>

<span class="c4 c8">[2.8](#h.3o7alnk)</span><span class="c4 c8">[Toward a Minimal Representation of Affective Gestures.pdf](#h.3o7alnk)</span>

<span class="c4 c8">[2.8.1](#h.23ckvvd)</span><span class="c4 c8">[Features tracked:](#h.23ckvvd)</span>

<span class="c4 c8">[2.8.2](#h.ihv636)</span><span class="c4 c8">[Framework used:](#h.ihv636)</span>

<span class="c4 c8">[2.8.3](#h.1hmsyys)</span><span class="c4 c8">[Results:](#h.1hmsyys)</span>

<span class="c4 c8">[2.9](#h.2grqrue)</span><span class="c4 c8">[Attributing Emotion to Static Body Postures.pdf](#h.2grqrue)</span>

<span class="c4 c8">[2.10](#h.3fwokq0)</span><span class="c4 c8">[Critical Features for the Perception of Emotion from Gait.pdf](#h.3fwokq0)</span>

<span class="c4 c8">[2.10.1](#h.1v1yuxt)</span><span class="c4 c8">[Conclusion](#h.1v1yuxt)</span>

<span class="c4 c8">[2.11](#h.4f1mdlm)</span><span class="c4 c8">[Other Papers](#h.4f1mdlm)</span>

<span class="c4 c8">[3](#h.2lwamvv)</span><span class="c4 c8">[Methodology](#h.2lwamvv)</span>

<span class="c4 c8">[3.1](#h.3l18frh)</span><span class="c4 c8">[Kinect](#h.3l18frh)</span>

<span class="c4 c8">[3.1.1](#h.206ipza)</span><span class="c4 c8">[Kinect Sensor Hardware](#h.206ipza)</span>

<span class="c4 c8">[3.1.2](#h.4k668n3)</span><span class="c4 c8">[Kinect Development Software](#h.4k668n3)</span>

<span class="c4 c8">[3.1.3](#h.2zbgiuw)</span><span class="c4 c8">[OpenKinect’s libfreenect](#h.2zbgiuw)</span>

<span class="c4 c8">[3.2](#h.1egqt2p)</span><span class="c4 c8">[CLNUI](#h.1egqt2p)</span>

<span class="c4 c8">[3.3](#h.3ygebqi)</span><span class="c4 c8">[OpenNI (Open Natural Interaction)](#h.3ygebqi)</span>

<span class="c4 c8">[3.4](#h.3cqmetx)</span><span class="c4 c8">[NITE](#h.3cqmetx)</span>

<span class="c4 c8">[3.5](#h.1rvwp1q)</span><span class="c4 c8">[Comparison between Microsoft’s SDK and OpenNI](#h.1rvwp1q)</span>

<span class="c4 c8">[3.6](#h.4bvk7pj)</span><span class="c4 c8">[Development Configurations](#h.4bvk7pj)</span>

<span class="c4 c8">[3.6.1](#h.2r0uhxc)</span><span class="c4 c8">[OpenNI](#h.2r0uhxc)</span>

<span class="c4 c8">[3.7](#h.1664s55)</span><span class="c4 c8">[Technologies Used:](#h.1664s55)</span>

<span class="c4 c8">[3.7.1](#h.3q5sasy)</span><span class="c4 c8">[Architecture](#h.3q5sasy)</span>

<span class="c4 c8">[3.7.2](#h.34g0dwd)</span><span class="c4 c8">[OpenFrameworks](#h.34g0dwd)</span>

<span class="c4 c8">[4](#h.1jlao46)</span><span class="c4 c8">[Results](#h.1jlao46)</span>

<span class="c4 c8">[5](#h.43ky6rz)</span><span class="c4 c8">[Discussion](#h.43ky6rz)</span>

<span class="c4 c8">[6](#h.2iq8gzs)</span><span class="c4 c8">[Conclusion](#h.2iq8gzs)</span>

<span class="c4 c8">7</span><span class="c4 c8">Recommendations</span>

<span class="c4 c8">[8](#h.xvir7l)</span><span class="c4 c8">[References](#h.xvir7l)</span>

<span class="c23 c12">LIST OF FIGURES</span>

<span class="c4 c8">[Figure 1: Framework Used for Gesture Representation](#h.32hioqz)</span>

<span class="c4 c8">[Figure 2: Cluster Membership of the 12 Emotion Classes with Each Cell Denoting a Portrayal](#h.41mghml)</span>

<span class="c4 c8">[Figure 3: Showing the Basic Layout of the Project](#h.111kx3o)</span>

<span class="c4 c8">[Figure 4: Three-Layered View of the OpenNI](#h.2dlolyb)</span>

<span class="c4 c8">[Figure 5: Example Scenario with Multiple Modules Registered to Work with an OpenNi Installation](#h.sqyw64)</span>

<span class="c4 c8">[Figure 6: Project Architecture](#h.kgcv8k)</span>

<span class="c23 c12">LIST OF TABLES</span>

<span class="c4 c8">[Table 1: Applications of Human Motion Analysis](#h.4d34og8)</span>

<span class="c4 c8">[Table 2: Showing Percentages of Successful Recognition of Static Postures by Observers](#h.vx1227)</span>

<span class="c23 c12">ABSTRACT</span>

<span class="c9">Since the release of Kinect, there have been many efforts from Microsoft, as well as, various other open source projects to track human motion. Many frameworks exist which give the developer an abstraction from tracking human movement and instead, provide them with parameters such as hand gestures. We aim to take it a step further. Using such frameworks, we analyzed hand and leg movements, combined with whole body’s motion to get a score of user’s emotions. Using the result of this analysis we developed a framework which other developers can use. While using this framework, they not only have hand and body movement data, but also the emotions of users which they can utilize in their applications. Applications can include creation of music and arts for the sake of advertisement, interactive installations and games which either use emotions as an input event or for studying emotional changes as a reaction to a certain event. </span>

<span class="c9">The second part of the project focuses on developing an application which demonstrates the full potential of this framework. We created a desktop application which will create real-time music and art based on the user performing intentionally or randomly. The music scale and saturation of the colors used is based upon the emotions of the performer.</span>

<span class="c23 c13 c12">Chapter 1</span>

1.  # <span>INTRODUCTION</span>

<span class="c9">Human beings are the most complex living organisms. Despite belonging to the mammals group, they are capable of evolving on such a fast scale and are able to redefine the aspects of their life through various means. Over the decades, human motions have shown such diversity that many scientists are trying to analyze and manipulate this knowledge to provide some benefit to the human race. In this regard, there are researches and attempts to read patterns in human motions and to use them to generate something useful such as art. This is a very promising avenue and can open doorways to more research and development. </span>

1.  ## <span>DEFINING ART AND HUMAN MOTIONS</span>

<span class="c9">Art is defined as the expression or application of human creative skill and imagination. Art combined with human motions can be described and can be taken in various meanings such as people dancing or an artifact depicting human motion.</span>

1.  ## <span>IMPORTANCE</span>

<span class="c9">The application of human motion analysis and utilization are vast. Some of the applications of such development can be seen as follows:</span>

<span class="c26 c12">Table 1: Applications of Human Motion Analysis</span>

<table cellpadding="0" cellspacing="0" class="c66"><tbody><tr class="c55"><td class="c86" colspan="1" rowspan="1">
<span class="c43 c12">Subject & environment</span>

<span class="c43 c12">Monitored</span>

</td><td class="c67" colspan="1" rowspan="1">
<span class="c43 c12">Parameters calculated</span>

</td><td class="c67" colspan="1" rowspan="1">
<span class="c12 c43">Output</span>

</td><td class="c87" colspan="1" rowspan="1">
<span class="c43 c12">Analysis/Application Domain</span>

</td></tr><tr class="c55"><td class="c74" colspan="1" rowspan="1">
<span class="c47 c40">Person performing intentionally.</span>

</td><td class="c34" colspan="1" rowspan="1">
*   <span class="c39 c40">Hands, arms, legs and body movement.</span>
*   <span class="c39 c40">Mood and gender.</span>

</td><td class="c34" colspan="1" rowspan="1">
<span class="c47 c40">Animation and music generated and color calculated .</span>

</td><td class="c78" colspan="1" rowspan="1">
<span class="c47 c40">Fun sake, dance performance, advertisement, gaming, one minute competition...what else?</span>

</td></tr><tr class="c55"><td class="c65" colspan="1" rowspan="1">
<span class="c47 c40">Person performing intentionally or randomly.</span>

</td><td class="c58" colspan="1" rowspan="1">
*   <span class="c39 c40">Hands, arms, legs and body movement.</span>
*   <span class="c39 c40">Mood and gender</span>

</td><td class="c58" colspan="1" rowspan="1">
<span class="c47 c40">Pre-generated 3D scene, such as wind, rain, movement of fish and blooming of flowers controlled by input parameters.</span>

</td><td class="c63" colspan="1" rowspan="1">
*   <span class="c39 c40">Used as installment in events, festivals, hotels’ lobby and museum.</span>
*   <span class="c39 c40">Uploading videos on social networking sites.</span>

</td></tr><tr class="c55"><td class="c82" colspan="1" rowspan="1">
<span class="c47 c40">Person agrees to be monitored at workplace and/or home.</span>

</td><td class="c10" colspan="1" rowspan="1">
*   <span class="c39 c40">Hands, arms, legs and body movement.</span>
*   <span class="c39 c40">Mood and gender</span>

</td><td class="c10" colspan="1" rowspan="1">
<span class="c47 c40">An animation or picture generated.</span>

</td><td class="c45" colspan="1" rowspan="1">
<span class="c47 c40">Animation and picture can be uploaded to social networking websites. Or we can make a Facebook page where people upload such videos/photos and people rate each of them.</span>

</td></tr><tr class="c55"><td class="c65" colspan="1" rowspan="1">
<span class="c47 c40">A group of people or even other objects moving in a specific area such as outside a building or at traffic signal.</span>

</td><td class="c58" colspan="1" rowspan="1">
<span class="c47 c40">Analyze movement of herds of objects?</span>

</td><td class="c58" colspan="1" rowspan="1">
<span class="c40 c47">An animation or picture.</span>

</td><td class="c63" colspan="1" rowspan="1">
<span class="c47 c40">Such a system can be installed outside a building which projects (maybe we can use projection mapping as well) movement of people inside/outside that biulding.</span>

</td></tr></tbody></table>
1.  ## <span>PROJECT GOAL</span>

<span class="c9">The goal of the project was to:</span>

1.  <span class="c9">Develop a framework that gathers mood and motion data. It means that our module will:</span>

*   <span class="c7">Capture human motion</span>
*   <span class="c7">Carry out mood/emotional analysis on it</span>
*   <span class="c7">And present the results in a well-formed, consistent manner so that it’s a breeze to use the module</span>

1.  <span class="c9">Write a demo application that shows full potential of this framework</span>

<span class="c23 c13 c12">Chapter 2</span>

1.  # <span>Literature Review</span>

# <span class="c38 c54"> Before starting to jump directly into developing this system, there was a need to see what had already been developed in the fields related to human motion analysis. In this regard, following papers were read and some conclusions were drawn depending on them:</span>

1.  ## <span>Human Motion Analysis</span>

1.  ### <span>Recognition and Re-synthesis of Human Motion with Personalized Variations</span>

<span class="c9">The purpose of this research paper was to analyze and recognize various human motions such as walking, jumping etc. It uses Hidden Markov Model recognize motion. This method was successful at recognizing different motions from a scene as well recognizing gender and mood of the actor with 100% accuracy.</span>

<span class="c9">In this research paper human motion data was gathered by infrared sensors placed at strategic locations on a human body but I chose to not write the details of the data gathering process as we are using Kinect and we will already have human motion data in the form of joints. </span>

<span class="c9">This paper also addressed the problem of transforming one type of motion into another. They used two different approaches to implement this and both were successful in transforming a male walk into a female walk.</span>

1.  ### <span>3D Human Action Recognition and Style Transformation Using Resilient Back propagation Neural Networks</span>

<span class="c9">This paper was published by the same authors as above but it uses Resilient Back propagation Neural Networks instead of Hidden Markov Model to implement the same principles as above. </span>

1.  ### <span>Conclusion</span>

<span class="c9">I have read, at a very abstract level both HMM and neural networks but both are fairly complex so a comparison at this time is not possible. I think we can decide on the algorithm to be used in the implementation phase after we know the exact form in which we have the data that is to be analyzed.</span>

<span class="c9">As far as re-synthesis is concerned, I don’t think we need re-synthesis as mentioned in both of these research papers. We are to create totally different form of artifacts from our motion analysis but gathering mood and gender can come in very handy.</span>

1.  ## <span>Color Detection and Optimization</span>

1.  ### <span>Aesthetic Coloring for Complex Layout Using Genetic Algorithm</span>

<span class="c9">Various research papers focused on generating a final color palette which an artist uses to choose a color from. But this paper solved the problem of generating an optimized color scheme based on a certain input colors. This paper relies on Moon (G.D. Birkhoff. Aesthetic Measure. Harvard University Press, Cambridge, MA, USA, 1933) and Spencer (P. Moo n, D.E. Spencer. Aesthetic measure applied to color harmony. Journal of the Optical Society of America, vol. 34, Apr. 1944, pp. 234-242.) color harmony model which is based on psychological experiments. They argue that Genetic Algorithms the best method to solve this kind of problem. </span>

<span class="c9">In 1928, Birkhoff formalized the notion of beauty by the introduction of the aesthetic measure, defined as the ratio between order and complexity. Based on this measure Moon and Spencer proposed a quantitative model of color harmony, using color difference and area factor based on psychological factors. </span>

<span class="c9">Implementation is carried out using three phases. In the first phase image they read and evaluate the color image and initialize genetic algorithm parameters. The program reads the size of image, number of color and color pairs and area of each color (read in pixels). Genetic algorithm parameters for this phase include string size, number of generations, population size, mutation and crossover rate. </span>

<span class="c9">In the second phase evaluation of the aesthetic score for each possible solution takes place. This determines the possibility of survival and reproduction of each solution in the following generations. </span>

<span class="c9">Phase 3 is population generation. For each generation, three ages of population (parent, child and combined) are created. The best solutions in this combined population regardless of their origin are retained and passed to the following generation as a parent population. </span>

<span class="c9">In the experiment conducted, it took them 55 seconds to read an image and search for 6 unique optimized solutions. </span>

1.  ### <span>Conclusion</span>

<span class="c9">There are also basic rules available to create color combinations. For example, if we hard code a certain color palette into out program and round-off each color read in the frame to one of those found in the color palette. This can be easily done in real time. While the solution mentioned in the research paper above is optimum, I think we are going to have a problem implementing that solution in real time. </span>

1.  ## <span>Psychological Analysis of Human Motion</span>

1.  ### <span>Affective States</span>

<span class="c9">Affect is described as feeling or emotion. Affective states refer to the different states of feelings or emotions.</span>

1.  ### <span>Difference between Emotion and Mood</span>

<span class="c9">Emotion and mood both are types of affective states but emotion is focused whereas mood is unfocused or diffused.</span>

1.  ### <span>Arousal, Valence and Stance</span>

<span class="c9">Arousal is defined as the level of energy a person possesses while displaying a certain emotion. Valence describes how positive or negative the stimuli is (which is causing a certain emotion in a person). Stance describes how approachable the stimuli are. </span>

<span class="c9">Together, these three terms form a model of quantitative analysis of emotion depicted by body language. </span>

1.  ### <span>Gesture</span>

<span class="c9">It is a movement of body that contains information.</span>

1.  ### <span>GEMEP</span>

<span class="c9">The Geneva Multimodal Emotion Portrayals (GEMEP</span><span class="c9 c64">[1]</span><span class="c9">) is a collection of audio and video recordings featuring 10 actors portraying 18 affective states, with different verbal contents and different modes of expression. It was created in Geneva by Klaus Scherer and Tanja Bänziger, in the framework of a project funded by the Swiss National Science Foundation (FNRS 101411-100367) and with support of the European Network of Excellence "Humaine" (IST-2002-2.3.1.6 Multimodal Interfaces, Contract no. 507422). Rating studies and objective behavioral analyses are also currently funded by Project 2 and the Methods module of the Swiss Affective Science Center Grant (FNRS).</span>

1.  ### <span>Importance of Body Language Analysis</span>

<span class="c9">There has been thorough research on motion analysis from facial recognition. But there has been little or no research on body language analysis. It is known that body expressions are as powerful as facial recognition when it comes to emotion analysis. In any social interactions, body language along with facial features communicates the mood/emotions of the person. </span>

<span class="c9">In chronic pain rehabilitation, specific movements and postural patterns inform about the emotional conflict experienced by the patients (called “guarding behavior”) which affects their level of ability to relax. If doctors have a way to know that a person’s emotional state is not letting him/her progress in his therapy, then they can formulate ways to treat such patients better. </span>

<span class="c9">Students lost motivation when high levels of affective states such as frustration, anxiety or fear are experienced. If such systems are developed which can read the body language of all students present in a class, it can point out when the teacher needs to change his/her tactics.</span>

1.  ### <span>Survey</span>

<span class="c9">The whole point of this research is to answer two questions:</span>

1.  <span class="c7">What bodily information is necessary for recognizing the emotional state of a person</span>
2.  <span class="c7">Whether specific features of the body can be identified which contribute to specific emotions in a person</span>

1.  ## <span class="c38">The Role of Spatial and Temporal Information in Biological Motion Perception.pdf</span>

<span class="c9">In the experiment conducted, 9 human walkers were fitted with point-lights on all major joints. There movements, both to the left and right, were recorded. From the movements, 100 static images were extracted based on the following four configurations:</span>

1.  <span class="c7">Normal spatial and temporal </span>
2.  <span class="c7">Scrambled spatial and normal temporal </span>
3.  <span class="c7">Normal spatial and scrambled temporal</span>
4.  <span class="c7">Scrambled spatial and temporal</span>

<span class="c9">The experiment was conducted by both, an algorithm and a human subject in two further stages. Stage 1 analyzed the spatial structure of the frame by matching with some templates of body shapes. Stage 2 analyzed the temporal arrangement. The task was to find the facing direction (form) of the point-light body and movement (motion) direction of the body.</span>

<span class="c9">The results show that form can be recognized when temporal data is scrambled and spatial data is intact. But movement cannot be analyzed when either of the data is scrambled. </span>

1.  ## <span class="c38">Evidence for Distinct Contributions of Form and Motion Information to the Recognition of Emotions from Body Gestures.pdf</span>

<span class="c9">The research concluded that motion signals alone are sufficient for recognizing basic emotions.</span>

1.  ## <span class="c38">Visual Perception of Expressiveness in Musician's Body Movements.pdf</span>

<span class="c9">Recognizing emotional intentions of a musician by their body movements. The results indicate that:</span>

*   <span class="c7">Happiness, sadness and anger are well communicated but fear was not</span>
*   <span class="c7">Anger is indicated by large, fairly fast and jerky movement</span>
*   <span class="c7">Sadness by fluid and slow movements</span>
*   <span class="c7">But expressions of the same motion varied greatly depending upon the instrument played</span>

1.  ## <span class="c38">Automated Analysis of Body Movement in Emotionally Expressive Piano Performances.pdf</span>

<span class="c9">While playing piano, movement is related to both the musical score that is being played as well as emotional intention conveyed. In the experiment conducted the pianist was asked to play the same musical score with different emotional intentions. Two motion cues were studied using an automated system:</span>

1.  <span class="c7">Quantity of motion of the upper body</span>
2.  <span class="c7">Velocity of head movement</span>

<span class="c9">The paper states that a comprehensive account of emotional communication should consider the entire path from sender to receiver. On the sender side, emotions are expressed with appearance and behavior by means of cues which can be objectively measured. On the receiver side, these cues are processed based upon the perception of the receiver. Receiver’s perception can be affected by many things such as culture and his own mood. So, although emotions perceived by the receiver are based on emotions expressed by the sender, but they are not necessarily equal.</span>

<span class="c9">This implies that a comprehensive account of emotion communication requires the conclusion of both expression and perception. </span>

<span class="c9">There are some distinctive patterns of movements and postural behavior associated with some of the emotions studied:</span>

1.  <span class="c7">Lifting shoulders seemed to be typical for </span><span class="c9 c13 c12">joy</span><span class="c7"> and </span><span class="c9 c13 c12">anger</span>
2.  <span class="c7">Moving shoulders forward is typical for </span><span class="c9 c13 c12">disgust</span><span class="c7">, </span><span class="c9 c13 c12">despair</span><span class="c7"> and </span><span class="c9 c12 c13">fear</span>

<span class="c9">Survey of various research papers concluded that head movement plays an important role in communication, as well as, perception of emotion.</span>

<span class="c9">For dance performances,</span>

1.  <span class="c7">Overall duration of time</span>
2.  <span class="c7">Contraction index</span>
3.  <span class="c7">Quantity of motion</span>
4.  <span class="c7">Motion fluency,</span>

<span class="c9">showed differences in four emotions: anger, fear, grief and joy. Another research indicated that quantity of motion and contraction index of upper body played a major role in discriminating between different emotions.</span>

1.  ### <span>Conclusions:</span>

<span class="c9">No other emotion, except for sad had any impact on quantity of motion (but this is because of lack of movement space due to piano)</span>

<span class="c9">Another research indicates that quantitative analysis of body expressions was also possible. For example, it was concluded that arm was raised 17 degrees higher for angry movements than other emotions and expanded limbs and torso both signify content and joy. </span>

1.  ## <span class="c38">Toward a Minimal Representation of Affective Gestures.pdf</span>

*   <span class="c7">12 emotions expressed by 10 actors</span>
*   <span class="c7">Visual tracking of trajectories of head and hands were performed from frontal and lateral view</span>
*   <span class="c7">Postural and dynamic expressive gesture features were identified and analyzed</span>

1.  ### <span>Features tracked:</span>

1.  <span class="c7">Overall amount of motion captured</span>
2.  <span class="c7">The degree of contraction and expansion of body computed using its bounded regions</span>
3.  <span class="c7">Motion fluency computed on the bases of the changes magnitude of the overall amount of motion over time </span>

1.  ### <span>Framework used:</span>

<span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 603.61px; height: 206.40px;">![](images/image04.jpg)</span>

<span class="c26 c12">Figure 1: Framework Used for Gesture Representation</span>

1.  <span class="c7">Module 1 computes low-level motion features i.e., the 3D positions and kinematics of head and hands</span>
2.  <span class="c7">Module 2 computes a vector of higher-level expressive gesture features, including the following five sets of features:</span>

1.  <span class="c7">Energy (passive vs. animated)</span>
2.  <span class="c7">Spatial extent (expanded vs. contracted)</span>
3.  <span class="c7">Smoothness and continuity of movement (gradual vs. jerky)</span>
4.  <span class="c7">Forward-backward leaning of the head</span>
5.  <span class="c7">Spatial symmetry and asymmetry of the hands with respect to the horizontal and vertical axis</span>

1.  <span class="c7">Module 3 reduces the dimensionality of the data, while highlighting the salient patterns in the data set</span>

<span class="c9">The paper also contains the details of how each of the features was computed as well as the Dimension Reduction Model.</span>

<span class="c9">Suggest that use of upper body only would be sufficient for classifying a large amount of effective behavior. </span>

1.  ### <span>Results:</span>

<span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 615.09px; height: 264.47px;">![](images/image05.png)</span>

<span class="c26 c12">Figure 2: Cluster Membership of the 12 Emotion Classes with Each Cell Denoting a Portrayal</span>

1.  ## <span>Attributing Emotion to Static Body Postures.pdf</span>

<span class="c60 c9">Static body postures were shown to various observers and they categorized various emotions. The result is as follows:</span>

<span class="c26 c12">Table 2: Showing Percentages of Successful Recognition of Static Postures by Observers</span>

<span style="overflow: hidden; display: inline-block; margin: 14.93px -14.93px; border: 0.00px solid #000000; transform: rotate(1.57rad) translateZ(0px); -webkit-transform: rotate(1.57rad) translateZ(0px); width: 624.02px; height: 594.16px;">![](images/image06.jpg)</span>

1.  ## <span class="c38">Critical Features for the Perception of Emotion from Gait.pdf</span>

<span class="c9">Carried out a 3-step process to extract and validate the minimum set of spatial-temporal motor primitives that drive the perception of particular emotions in gait. They showed that perception of emotions is based on specific changes in joint angles amplitudes with respect to the pattern of neutral walk. They also studied the after-effects of emotions and concluded that there were after-affects in perception of sad and happy movements, indicating that the feature sets are complete. </span>

1.  ### <span>Conclusion</span>

<span class="c9">Arms straight down, close to the side of the body indicates sadness (but head position also plays an important role, for example, bent forward for disgust and backward for pride). </span>

<span class="c9">While some emotion categories do share a core set of body expressions, they also exhibit a number of variations for other body parts. For example, happiness and elated joy are indicated by head bent back in some studies. In some studies arms are raised while they remain straight down in Critical Features for the Perception of Emotion from Gait.pdf (which may be due to the contextual factor of gait).</span>

<span class="c9">More than one body expression pattern may be associated with the same emotion category. So, there are contextual factors which may affect the emotional state’s expression. Components that make up an emotion expressed are not fixed and each emotion reaction is not unique. But, discriminative patterns may emerge when context is not considered. </span>

1.  ## <span class="c12 c46">Other Papers</span>

*   ## <span class="c9 c12">Multimodal Analysis of Expressive Gesture in Music and Dance Performances .pdf</span>

*   ## <span class="c9 c12">Gesture Based Affective Computing on Motion Capture Data.pdf</span>

*   ## <span class="c9 c12">Estimating the Efficiency of Recognizing Gender and Affect from Biological Motion.pdf</span>

*   ## <span class="c9 c12"> Detecting Affect from Non-Stylised Body Motions.pdf</span>

*   ## <span class="c9 c12">Exploring Non-Verbal Communication in Human-Machine Interaction.pdf</span>

*   ## <span class="c9 c12">Automatic Recognition of Affective Body Movement in a Video Game Scenario.pdf</span>

*   ## <span class="c9 c12">Affective Computing.ppt</span>

*   ## <span class="c9 c12">Visual Informatics - Bridging Research and Practice.pdf </span>

<span class="c9">The above papers show automatic recognition of bodily expressions mono-modally.</span>

<span class="c9">I studied recognizing emotional states of people playing tennis on Wii. Individual idiosyncrasies were removed by normalizing each expression according to min and max value of the features for that participant. </span>

<span class="c9">Best results were obtained using angular velocity, angular frequency and amount of movement. Overall the system was able to correctly classify a high percentage of both the high and low-intensity negative expression and the happiness expressions, but considerably fewer of the concentration expressions. </span>

<span class="c9">In tennis, some played using their hands and wrists while some with shoulders and arms. In hand/wrists combination, negative emotions may be expressed by jerky and fast movements of the wrists while in latter, with jerky movements of the larger body. </span>

*   <span class="c7">Probabilistic Combination of Multiple Modalities to Detect Interest.pdf</span>
*   <span class="c7">Multimodal Emotion Recognition from Expressive Faces, Body Gestures and Speech.pdf</span>
*   <span class="c7">Automatic Temporal Segment Detection and Affect Recognition From Face and Body Display.pdf</span>
*   <span class="c7">Beyond Facial Expressions.pdf </span>

<span class="c9">The above mentioned papers show automatic recognition multi-modally.</span>

*   <span class="c7">Emotion Recognition from Dance Image Sequences Using Contour Approximation.pdf</span>
*   <span class="c7">Interactive System Design.pdf</span>
*   <span class="c7">Extraction of Motion Characteristics Corresponding to Sensitivity Information Using Dance Mvoement.pdf</span>
*   <span class="c7">Emotional Body Movements.pdf</span>

<span class="c9">Majority of above mentioned affective recognition systems have focused on dance performances. </span>

<span class="c9">Recognition of fear was most often misclassified as anger. Misclassification of grief and joy is interesting since joy movements are very fluid and grief movements are not. </span>

<span class="c9">These systems are relatively successful but dance movements are generally exaggerated while day-to-day body movements are generally subtle. </span>

<span class="c23 c13 c12">Chapter 3</span>

1.  # <span>Methodology</span>

<span class="c9">Figure 3 describes high level architecture of what the project was intended to accomplish:</span>

<span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 569.33px; height: 233.13px;">![](images/image07.png)</span>

<span class="c26 c12">Figure 3: Showing the Basic Layout of the Project</span>

1.  ## <span>Kinect </span>

<span class="c9">This portion of the document describes Kinect hardware and various software frameworks to be used with Kinect. Microsoft has a well-documented Kinect SDK (for windows only) but some third-party SDK’s and drivers, as well as frameworks are also available. I propose that we use OpenNI coupled with NITE (both are explained below) instead of Microsoft’s SDK as they are open source (you need to purchase a license to use Microsoft’s Kinect SDK for commercial purposes) and can be easily ported to Mac and Linux.</span>

1.  ### <span>Kinect Sensor Hardware</span>

<span class="c9">The Kinect sensor includes:</span>

1.  <span class="c7">RGB camera</span>
2.  <span class="c7">Depth sensor</span>
3.  <span class="c7">Multi-array microphones</span>
4.  <span class="c7">Tilt motor</span>
5.  <span class="c7">Three-axis accelerometer</span>

<span class="c9">The Kinect’s depth sensor consists of an infrared light source , a laser that projects a pattern of dots, that are read back by a monochrome CMOS IR sensor. The sensor detects reflected segments of the dot pattern and converts their intensities into distances. The resolution of the depth dimension (z-axis) is about one centimeter while spatial resolution (x- and y-axes) is in millimeters. Each frame generated by the depth sensor is at VGA resolution (640 x 480 pixels), containing 11-bit depth values which provides 2,048 levels of sensitivity. The output stream runs at a frame rate of 30 Hz.</span>

<span class="c9">The RGB video stream also utilizes VGA resolution and a 30 Hz frame rate. </span>

<span class="c9">The audio array consists of four microphones, with each channel processing 16-bit audio at a sampling rate of 16 KHz. The hardware includes ambient noise suppression. </span>

<span class="c9">Microsoft suggests that you allow about 6 feet of empty space between you and the sensor otherwise you can confuse the sensor. </span>

1.  ### <span>Kinect Development Software</span>

<span class="c9">There are four main Kinect development libraries:</span>

1.  <span class="c7">OpenKinect’s libfreenect</span>
2.  <span class="c7">CLNUI</span>
3.  <span class="c7">OpenNI</span>
4.  <span class="c7">Microsoft’s Kinect for Windows</span>

1.  ### <span>OpenKinect’s libfreenect</span>

<span class="c9">Libfreenect is derived from a reverse-engineered Kinect driver and works across all OS platforms. OpenKinect Analysis library communicates with the OpenKinect API and analyzes the raw information into more useful abstractions. They aim to to implement the following features but </span><span class="c9 c12">most of them have not been implemented yet</span><span class="c9">:</span>

*   <span class="c1">hand tracking</span>
*   <span class="c1">skeleton tracking</span>
*   <span class="c1">other depth processing</span>
*   <span class="c1">3D audio isolation </span><span class="c1 c13">coning?</span>
*   <span class="c1">audio cancellation (</span><span class="c1 c13">perhaps a driver feature?</span><span class="c1">)</span>
*   <span class="c1">Point cloud generation</span>
*   <span class="c1">Inertial movement tracking with the built in accelerometer or an attached WiiMote</span>
*   <span class="c1">3d reconstruction</span>
*   <span class="c1">GPU acceleration for any of the above</span>

1.  ## <span>CLNUI</span>

<span class="c9">CLNUI is aimed for windows only but </span><span class="c9 c12">allows multiple kinects</span><span class="c9"> to work together. </span>

1.  ## <span>OpenNI (Open Natural Interaction)</span>

<span class="c9">OpenNI is a software framework and an API and provides support for:</span>

1.  <span class="c7">Voice and voice command recognition</span>
2.  <span class="c7">Hand gestures</span>
3.  <span class="c7">Body Motion Tracking</span>

<span class="c9">OpenNI is a multi-language, cross-platform framework that defines API’s for writing applications utilizing Natural Interaction. The main advantage of this framework is that you write software independent of the hardware. So, for example, we can aim to write a Human Motion Analysis program which can analyze human motion using kinect if it is available or the same program would use a camera if Kinect is not available. </span>

<span class="c9">Figure 4 shows the three-layered view of the OpenNI concept: </span>

<span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 688.51px; height: 358.27px;">![](images/image01.jpg)</span>

<span class="c26 c12">Figure 4: Three-Layered View of the OpenNI</span>

<span class="c9">Sensor modules that are currently supported are:</span>

1.  <span class="c7">3D sensor</span>
2.  <span class="c7">RGB camera</span>
3.  <span class="c7">IR camera</span>
4.  <span class="c7">A microphone or an array of microphones</span>

<span class="c9">Middleware components that are supported are:</span>

1.  <span class="c7">Full body analysis middleware: a software component that processes sensory data and generates body related information (typically data structure that describes joints, orientation, center of mass, and so on)</span>
2.  <span class="c7">Hand point analysis middeware: a software component that processes sensory data and generates the location of a hand point</span>
3.  <span class="c7">Gesture detection middleware: a software component that identifies predefined gestures (for example, a waving hand) and alerts the application</span>
4.  <span class="c7">Scene analyzer middleware: a software component that analyzes the image of the scene in order to produce such information as:</span>

1.  <span class="c7">The seperation between the foreground of the scene and the background</span>
2.  <span class="c7">The coordination of the floor plane</span>
3.  <span class="c7">The individual identification of figures in the scene (and output its current location and orientation of joints of this figure)</span>

<span class="c9">Figure 5 describes an example scenario in which multiple modules are registered to work with an OpenNi installation:</span>

<span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 624.00px; height: 470.67px;">![](images/image00.jpg)</span>

<span class="c12 c26">Figure 5: Example Scenario with Multiple Modules Registered to Work with an OpenNi Installation</span>

<span class="c9">OpenNI’s Kinect driver is called SensorKinect. </span><span class="c9 c12">One drawback of using OpenNI will be that tilt motor, status light and accelerometer will not be available.</span>

1.  ## <span>NITE</span>

<span class="c9">An important reason for using OpenNI is its support for middleware. The NITE library understands the different hand movements as gesture types based on how hand points change over time. NITE gestures include:</span>

1.  <span class="c7">Pushing</span>
2.  <span class="c7">Swiping</span>
3.  <span class="c7">Holding steady</span>
4.  <span class="c7">Waving</span>
5.  <span class="c7">Hand circling</span>

<span class="c9">“</span><span class="c9 c13">Primesense’s NITE middleware allows computers or digital devices to perceive the world in 3D. NITE comprehends your movements and interactions within its view, translates them into application inputs, and responds to them without any wearable input</span><span class="c9">.”</span>

<span class="c9">Including computer vision algorithms, NITE identifies users and tracks their movements, and provides the framework API for implementing Natural-Interaction UI controls based on gestures. </span><span class="c9 c12">NITE can detect when you want to control things with only hand gestures, or when to get your whole body involved. </span>

<span class="c9 c12">Hand control</span><span class="c9">: allows you to control digital devices with your bare hands and as long as you’re in control, NITE ignores what others are doing.</span>

<span class="c9 c12">Full body control</span><span class="c9">: lets you have a total immersive, full body video game experience. NITE middleware supports multiple users, and is designed for all types of action.</span>

1.  ## <span>Comparison between Microsoft’s SDK and OpenNI</span>

<span class="c9">Microsoft’s Kinect SDK covers much the same ground as OpenNI. The low-level API gives access to the depth sensor, image sensor, and microphone array, while higher-level features include skeletal tracking, audio processing, and integration with the Windows speech recognition API.</span>

<span class="c9">The main area where SDK wins over OpenNI is audio. Other pluses for Microsoft’s Kinect SDK are its extensive documentation and ease of installation on Windows 7\. The main drawback for Microsoft’s SDK is that it only works for Windows 7, not even Windows XP. The SDK is free but limited to non-commercial purposes.</span>

1.  ## <span>Development Configurations</span>

1.  ### <span>OpenNI</span>

1.  #### <span>Installing OpenNI and Kinect Driver on Windows 7 (x86) </span>

1.  <span class="c9">Go to </span><span class="c8 c9">[http://openni.org/Downloads/OpenNIModules.aspx](http://www.google.com/url?q=http%3A%2F%2Fopenni.org%2FDownloads%2FOpenNIModules.aspx&sa=D&sntz=1&usg=AFQjCNFbLsvOWyCioicKHYSFz9pGDiKLLg)</span>

1.  <span class="c9">Select OpenNI Packages</span>
2.  <span class="c9">Select Stable</span>
3.  <span class="c9">Select PrimeSense Package Stable Build for Windows x86 Development Edition</span>

1.  <span class="c9">While installing, select OpenNI and NITE middleware. DO NOT check PrimeSense hardware as that driver is not for Microsoft Kinect </span>
2.  <span class="c9">Download Kinect driver from </span><span class="c8 c9">[https://github.com/avin2/SensorKinect](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Favin2%2FSensorKinect&sa=D&sntz=1&usg=AFQjCNG0TnaQeP_oAXI2hXKwnXVatZ41lQ)</span><span class="c9"> (make sure that neither Microsoft’s nor any other driver for Kinect is installed on your computer) and install it.</span>
3.  <span class="c9">To run the samples included with NITE, copy all .xml files from “[PrimeSense root directory]/NITE/Data” to “[PrimeSense root directory]/SensorKinect/Data”</span>

1.  #### <span>Configuring OpenNI Development in Visual Studio 2010</span>

1.  <span class="c7">Create a new or open an existing Visual Studio 2010 project</span>
2.  <span class="c7">Open project properties</span>
3.  <span class="c7">Go to </span><span class="c9 c12">C/C++ -> General -> Additional Include Directories</span><span class="c7"> and add “[OpenNI root directory]/Include”</span>
4.  <span class="c7">Go to </span><span class="c9 c12">Linker -> General -> Additional Library Directories </span><span class="c7">and add “[OpenNI root directory]/Lib”</span>
5.  <span class="c7">Go to </span><span class="c9 c12">Linker -> Input -> Additional Dependencies </span><span class="c7">and add </span><span class="c9 c12">OpenNI.lib</span>
6.  <span class="c7">Your code should include </span><span class="c9 c12">XnOpenNI.h</span><span class="c7"> if you are using C interface, or </span><span class="c9 c12">XnCppWrapper.h</span><span class="c7"> if you are using C++ interface </span>
7.  <span class="c7">Optionally, you can use the namespace “xn” or you can reference objects using scope operator (For example, “xn::Context context”)</span>

1.  #### <span>Configuring OpenNI Development in Visual Studio 2012</span>

<span class="c9">Installation and configuration in Visual Studio 2012 is exactly the same as Visual Studio 2010\. But OpenNI doesn’t let you use their library in compiler version greater than VS 2010\. But it can be overridden using the following steps:</span>

1.  <span class="c7">Within the OpenNI libraries directory, locate the file XnPlatform.h</span>
2.  <span class="c7">At the top of the file you will find the code “if defined(_WIN32). Beneath this you will find another condition which checks the compiler version</span>
3.  <span class="c7">Comment out that piece of code and you will be able to compile the project</span>

1.  #### <span>Configuring OpenNI Development in Java IDE’s</span>

1.  <span class="c7">Create a new project in Eclipse or Netbeans</span>
2.  <span class="c7">Add “[OpenNI root directory]/Bin/org.OpenNI.jar” and “[NITE root directory]/Bin/com.primesense.NITE.jar” to “additional libraries</span>

1.  ## <span>Technologies Used:</span>

1.  <span class="c7">Microsoft Windows 7 (x86)</span>
2.  <span class="c7">PrimeSense’s SensorKinect driver for Kinect</span>
3.  <span class="c7">NITE middleware for OpenNI</span>
4.  <span class="c7">OpenNI</span>

1.  ### <span>Architecture</span>

<span style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 194.98px; height: 307.96px;">![](images/image02.png)</span>

<span class="c26 c12">Figure 6: Project Architecture</span>

1.  ### <span>OpenFrameworks</span>

1.  <span class="c7">Download the latest release of OpenFrameworks from </span><span class="c7 c8">[http://www.openframeworks.cc/download/](http://www.google.com/url?q=http%3A%2F%2Fwww.openframeworks.cc%2Fdownload%2F&sa=D&sntz=1&usg=AFQjCNHJZ9vtsnIAeGprJX3wojcQilQBLg)</span>
2.  <span class="c7">There you go! Run any of the example from the openFrameworks’ directory</span>

<span class="c23 c13 c12">Chapter 4</span>

1.  # <span>Results</span>

<span class="c9">Two major emotions, happiness and anger were taken into consideration. These two emotions were distinguished by only using the upper body data. Music was generated using motion of hands of the user as input. Emotional data was used to normalize the music generated to map it onto a musical scale so that it sounded aesthetically pleasing.</span>

<span class="c23 c13 c12">Chapter 5</span>

1.  # <span>Discussion</span>

<span class="c9">Where body language is a crucial part of emotional detection, either by another human or a computer device, it is not complete. Current state of body language largely depends on the context. For example, people playing tennis would depict different emotions differently through body language than people playing piano. This is because in each of the situation, body language will have different constraints and the subject can only show movement in certain directions. </span>

<span class="c9">Secondly, real-time generation of music according to the emotion, and which also sounds that way to an untrained ear also lacks accuracy.</span>

<span class="c23 c13 c12">Chapter 6</span>

1.  # <span>Conclusion</span>

<span class="c9">We conclude that body language alone is not sufficient for accurately determining the emotion of a person. But, coupled with facial expression analysis and vocal analysis, these three complete the method in which emotions are perceived by human beings and hence, it does have the potential of increasing the computer-aided emotion detection. </span>

<span class="c23 c13 c12">Chapter 7</span>

1.  # <span>References</span>

<span class="c9">[1] </span><span class="c8 c9">[http://www.affective-sciences.org/gemep](http://www.google.com/url?q=http%3A%2F%2Fwww.affective-sciences.org%2Fgemep&sa=D&sntz=1&usg=AFQjCNEMz4odhreuo05hwNC5KbkwMKtaQA)</span>

<span class="c8 c9">[2]</span><span class="c8 c9">[http://www.openframeworks.cc/download/](http://www.google.com/url?q=http%3A%2F%2Fwww.openframeworks.cc%2Fdownload%2F&sa=D&sntz=1&usg=AFQjCNHJZ9vtsnIAeGprJX3wojcQilQBLg)</span>

<span class="c8 c9">[3]</span><span class="c8 c9">[https://github.com/avin2/SensorKinect](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Favin2%2FSensorKinect&sa=D&sntz=1&usg=AFQjCNG0TnaQeP_oAXI2hXKwnXVatZ41lQ)</span>

<div>
<span class="c13 c12 c35">Human Motion Analysis and Art and Music Generation</span>

</div>
