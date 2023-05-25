const ALL = {eng: "ALL", kor: "전체"};
const UROLOGY = {eng: 'UROLOGY', kor: "비뇨기과"};
const OBSTETRICS_AND_GYNECOLOGY = {eng: 'OBSTETRICS_AND_GYNECOLOGY', kor: "산부인과"};
const PEDIATRICS = {eng: 'PEDIATRICS', kor: "소아청소년과"};
const EYE_CLINIC = {eng: 'EYE_CLINIC', kor: "안과"};
const ENT_CLINIC = {eng: 'ENT_CLINIC', kor: "이비인후과"};
const MENTAL_HEALTH = {eng: 'MENTAL_HEALTH', kor: "정신건강의학과"};
const ORTHOPEDICS = {eng: 'ORTHOPEDICS', kor: "정형외과"};
const DERMATOLOGY = {eng: 'DERMATOLOGY', kor: "피부과"};
const DENTIST = {eng: 'DENTIST', kor: "치과"};
const OTHERS = {eng: 'OTHERS', kor: "기타"};

const departments = [
    ALL,
    UROLOGY,
    OBSTETRICS_AND_GYNECOLOGY,
    PEDIATRICS,
    EYE_CLINIC,
    ENT_CLINIC,
    MENTAL_HEALTH,
    ORTHOPEDICS,
    DERMATOLOGY,
    DENTIST,
    OTHERS
]

function getDepartment(typeName) {
    let department = departments.find(d => d.eng === typeName || d.kor === typeName);
    return department ? department : ALL;
}
