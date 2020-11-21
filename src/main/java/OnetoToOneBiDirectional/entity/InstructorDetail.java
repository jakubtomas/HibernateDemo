package OnetoToOneBiDirectional.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    // new line Bi directional
 //   @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)

    // Only delete InstructorDetail Keep the Instructor

     @OneToOne(mappedBy = "instructorDetail",
     cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST ,
     CascadeType.REFRESH})
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }


}
